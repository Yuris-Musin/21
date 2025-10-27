package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.musindev.ochko.domain.model.Hand

@Composable
fun PlayerHandView(
    hand: Hand,
    modifier: Modifier = Modifier
) {
    HandView(
        title = "Ваша рука: ${hand.getValue()}",
        hand = hand,
        modifier = modifier
    )
}

@Composable
fun DealerHandView(
    hand: Hand,
    modifier: Modifier = Modifier
) {
    HandView(
        title = "Рука дилера: ${hand.getValue()}",
        hand = hand,
        modifier = modifier
    )
}

@Composable
private fun HandView(
    title: String,
    hand: Hand,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(hand.cards) { card ->
                CardView(card = card)
            }
        }
    }
}
