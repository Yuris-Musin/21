package ru.musindev.ochko.domain.usecase

import ru.musindev.ochko.domain.model.Hand

class ShouldDealerDrawUseCase {
    operator fun invoke(dealerHand: Hand): Boolean {
        return dealerHand.getValue() < 17
    }
}