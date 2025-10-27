package ru.musindev.ochko.domain.usecase

import ru.musindev.ochko.domain.model.GameResult
import ru.musindev.ochko.domain.model.Hand

class CheckWinnerUseCase {
    operator fun invoke(playerHand: Hand, dealerHand: Hand): GameResult {
        val playerValue = playerHand.getValue()
        val dealerValue = dealerHand.getValue()

        if (playerHand.isGoldenBlackjack()) {
            return GameResult.PLAYER_GOLDEN_BLACKJACK
        }

        if (playerHand.isBlackjack() && !dealerHand.isBlackjack()) {
            return GameResult.PLAYER_BLACKJACK
        }

        if (playerHand.isBust()) return GameResult.PLAYER_BUST
        if (dealerHand.isBust()) return GameResult.DEALER_BUST

        return when {
            playerValue > dealerValue -> GameResult.PLAYER_WIN
            playerValue < dealerValue -> GameResult.DEALER_WIN
            else -> GameResult.PUSH
        }
    }
}
