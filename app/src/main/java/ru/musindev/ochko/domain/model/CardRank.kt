package ru.musindev.ochko.domain.model

enum class CardRank(val value: Int, val displayName: String) {
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(2, "В"),    // Валет = 2
    QUEEN(3, "Д"),   // Дама = 3
    KING(4, "К"),    // Король = 4
    ACE(11, "Т")     // Туз = 11 или 1
}