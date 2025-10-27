package ru.musindev.ochko.domain.usecase

import ru.musindev.ochko.domain.model.Hand

class CalculateHandValueUseCase {
    operator fun invoke(hand: Hand): Int = hand.getValue()
}
