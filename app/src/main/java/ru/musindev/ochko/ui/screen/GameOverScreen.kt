package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameOverScreen(
    result: String,
    onPlayAgain: () -> Unit,
    onNavigateToMenu: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = getResultText(result),
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onPlayAgain,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Играть ещё")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToMenu,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("В меню")
        }
    }
}

private fun getResultText(result: String): String {
    return when (result) {
        "PLAYER_WIN" -> "Вы выиграли!"
        "DEALER_WIN" -> "Дилер выиграл"
        "PUSH" -> "Ничья"
        "PLAYER_BUST" -> "Перебор!"
        "DEALER_BUST" -> "У дилера перебор!"
        "PLAYER_BLACKJACK" -> "Очко!"
        "PLAYER_GOLDEN_BLACKJACK" -> "Золотое очко!"
        else -> "Игра окончена"
    }
}
