package ru.musindev.ochko.domain.model

sealed class GameState {
    object Initial : GameState()
    object PlayerTurn : GameState()
    object DealerTurn : GameState()
    data class GameOver(val result: GameResult) : GameState()
}

enum class GameResult {
    PLAYER_WIN,
    DEALER_WIN,
    PUSH,
    PLAYER_BUST,
    DEALER_BUST,
    PLAYER_BLACKJACK,
    PLAYER_GOLDEN_BLACKJACK
}
