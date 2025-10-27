package ru.musindev.ochko.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.musindev.ochko.domain.model.Card
import ru.musindev.ochko.domain.model.GameResult
import ru.musindev.ochko.domain.model.GameState
import ru.musindev.ochko.domain.model.Hand
import ru.musindev.ochko.domain.repository.DeckRepository
import ru.musindev.ochko.domain.usecase.CalculateHandValueUseCase
import ru.musindev.ochko.domain.usecase.CheckWinnerUseCase
import ru.musindev.ochko.domain.usecase.ShouldDealerDrawUseCase
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val deckRepository: DeckRepository,
    private val calculateHandValueUseCase: CalculateHandValueUseCase,
    private val shouldDealerDrawUseCase: ShouldDealerDrawUseCase,
    private val checkWinnerUseCase: CheckWinnerUseCase
) : ViewModel() {

    private val _gameState = MutableStateFlow<GameState>(GameState.Initial)
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private val _playerHand = MutableStateFlow(Hand())
    val playerHand: StateFlow<Hand> = _playerHand.asStateFlow()

    private val _dealerHand = MutableStateFlow(Hand())
    val dealerHand: StateFlow<Hand> = _dealerHand.asStateFlow()

    private var deck: MutableList<Card> = mutableListOf()

    fun startNewGame() {
        // Создаём и перемешиваем колоду
        deck = deckRepository.shuffleDeck(
            deckRepository.createDeck()
        ).toMutableList()

        // Раздаём начальные карты
        val playerCards = mutableListOf(drawCard())
        val dealerCards = mutableListOf(drawCard())

        _playerHand.value = Hand(playerCards)
        _dealerHand.value = Hand(dealerCards)
        _gameState.value = GameState.PlayerTurn
    }

    fun playerHit() {
        if (_gameState.value !is GameState.PlayerTurn) return

        val newHand = Hand(_playerHand.value.cards + drawCard())
        _playerHand.value = newHand

        if (newHand.isBust()) {
            _gameState.value = GameState.GameOver(GameResult.PLAYER_BUST)
            return
        }

        if (newHand.is21()) {
            playerStand()
        }
    }

    fun playerStand() {
        if (_gameState.value !is GameState.PlayerTurn) return

        _gameState.value = GameState.DealerTurn
        viewModelScope.launch {
            dealerPlay()
        }
    }

    private suspend fun dealerPlay() {
        delay(1000)

        while (shouldDealerDrawUseCase(_dealerHand.value)) {
            val newHand = Hand(_dealerHand.value.cards + drawCard())
            _dealerHand.value = newHand
            delay(1000)

            if (newHand.isBust()) break
        }

        val result = checkWinnerUseCase(_playerHand.value, _dealerHand.value)
        _gameState.value = GameState.GameOver(result)
    }

    private fun drawCard(): Card {
        if (deck.isEmpty()) {
            deck = deckRepository.shuffleDeck(
                deckRepository.createDeck()
            ).toMutableList()
        }
        return deck.removeAt(0)
    }
}
