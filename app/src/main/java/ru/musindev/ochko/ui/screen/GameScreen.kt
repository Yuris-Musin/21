package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.musindev.ochko.DynamicOverlappingCards
import ru.musindev.ochko.R

@Composable
fun GameScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Счет: 15")
            Text("Игрок: Иван")
        }
        Spacer(Modifier.height(32.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Здесь Image/card graphics
            DynamicOverlappingCards(
                cardResIds = listOf(
                    R.drawable.img_6c,
                    R.drawable.img_6d
                    ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                cardHeightDp = 100
            )
        }
        Spacer(Modifier.height(32.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {  }) { Text("Карта") }
            Button(onClick = {  }) { Text("Стоп") }
            Button(onClick = {  }) { Text("Новая игра") }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    GameScreen()
}