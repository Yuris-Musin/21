package ru.musindev.ochko.domain.repository

import ru.musindev.ochko.domain.model.Card

interface DeckRepository {
    fun createDeck(): List<Card>
    fun shuffleDeck(cards: List<Card>): List<Card>
}
