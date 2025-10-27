package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.musindev.ochko.domain.model.Card
import ru.musindev.ochko.domain.model.CardSuit
import ru.musindev.ochko.R

@Composable
fun CardView(
    card: Card,
    modifier: Modifier = Modifier
) {
    // ВАРИАНТ 1: Если у тебя УЖЕ ЕСТЬ изображения карт в drawable
    // Используем их напрямую
    val imageRes = getCardImageResource(card)

    if (imageRes != null) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "${card.rank.displayName} ${card.suit.symbol}",
            modifier = modifier
                .size(width = 80.dp, height = 112.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    } else {
        // ВАРИАНТ 2: Если изображений НЕТ - рисуем простую карту текстом
        FallbackCardView(card = card, modifier = modifier)
    }
}

@Composable
private fun FallbackCardView(
    card: Card,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 80.dp, height = 112.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = card.rank.displayName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = when (card.suit) {
                    CardSuit.HEARTS, CardSuit.DIAMONDS -> Color.Red
                    CardSuit.CLUBS, CardSuit.SPADES -> Color.Black
                }
            )
            Text(
                text = card.suit.symbol,
                fontSize = 32.sp,
                color = when (card.suit) {
                    CardSuit.HEARTS, CardSuit.DIAMONDS -> Color.Red
                    CardSuit.CLUBS, CardSuit.SPADES -> Color.Black
                }
            )
        }
    }
}

/**
 * Функция для маппинга Card на drawable ресурс
 * ВАЖНО: Проверь, какие имена файлов у тебя в drawable
 */
private fun getCardImageResource(card: Card): Int? {
    // Формат имени файла: card_6h, card_7d, card_jc, card_ks и т.д.
    val rankCode = when (card.rank) {
        ru.musindev.ochko.domain.model.CardRank.SIX -> "6"
        ru.musindev.ochko.domain.model.CardRank.SEVEN -> "7"
        ru.musindev.ochko.domain.model.CardRank.EIGHT -> "8"
        ru.musindev.ochko.domain.model.CardRank.NINE -> "9"
        ru.musindev.ochko.domain.model.CardRank.TEN -> "10"
        ru.musindev.ochko.domain.model.CardRank.JACK -> "j"
        ru.musindev.ochko.domain.model.CardRank.QUEEN -> "q"
        ru.musindev.ochko.domain.model.CardRank.KING -> "k"
        ru.musindev.ochko.domain.model.CardRank.ACE -> "a"
    }

    val suitCode = when (card.suit) {
        CardSuit.HEARTS -> "h"
        CardSuit.DIAMONDS -> "d"
        CardSuit.CLUBS -> "c"
        CardSuit.SPADES -> "s"
    }

    val resourceName = "card_${rankCode}${suitCode}"

    // Пытаемся найти ресурс по имени
    return try {
        R.drawable::class.java.getField(resourceName).getInt(null)
    } catch (e: Exception) {
        null  // Если не нашли - вернём null, будет использован FallbackCardView
    }
}
