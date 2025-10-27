package ru.musindev.ochko.domain.model

data class Card(
    val rank: CardRank,
    val suit: CardSuit
) {
    val code: String
        get() = "${rank.name}_${suit.name}"
}