package ru.musindev.ochko.data.repository

import ru.musindev.ochko.domain.model.Card
import ru.musindev.ochko.domain.model.CardRank
import ru.musindev.ochko.domain.model.CardSuit
import ru.musindev.ochko.domain.repository.DeckRepository

class DeckRepositoryImpl : DeckRepository {
    override fun createDeck(): List<Card> {
        val deck = mutableListOf<Card>()

        CardSuit.entries.forEach { suit ->
            listOf(
                CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT,
                CardRank.NINE, CardRank.TEN, CardRank.JACK,
                CardRank.QUEEN, CardRank.KING, CardRank.ACE
            ).forEach { rank ->
                deck.add(Card(rank, suit))
            }
        }

        return deck
    }

    override fun shuffleDeck(cards: List<Card>): List<Card> {
        return cards.shuffled()
    }
}
