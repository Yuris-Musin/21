package ru.musindev.ochko.domain.model

data class Hand(
    val cards: List<Card> = emptyList()
) {
    fun getValue(): Int {
        var sum = 0
        var aceCount = 0

        cards.forEach { card ->
            if (card.rank == CardRank.ACE) {
                aceCount++
            } else {
                sum += card.rank.value
            }
        }

        // Оптимально добавляем тузы
        repeat(aceCount) {
            sum += if (sum + 11 <= 21) 11 else 1
        }

        return sum
    }

    fun isBust(): Boolean = getValue() > 21
    fun is21(): Boolean = getValue() == 21
    fun isBlackjack(): Boolean = cards.size == 2 && is21()
    fun isGoldenBlackjack(): Boolean =
        cards.size == 2 && cards.all { it.rank == CardRank.ACE }
}
