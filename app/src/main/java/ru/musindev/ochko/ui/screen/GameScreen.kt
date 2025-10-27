package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.musindev.ochko.domain.model.GameState
import ru.musindev.ochko.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToGameOver: (String) -> Unit
) {
    val gameState by viewModel.gameState.collectAsState()
    val playerHand by viewModel.playerHand.collectAsState()
    val dealerHand by viewModel.dealerHand.collectAsState()

    LaunchedEffect(gameState) {
        if (gameState is GameState.GameOver) {
            val result = (gameState as GameState.GameOver).result
            onNavigateToGameOver(result.name)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Кнопка назад
        IconButton(onClick = onNavigateBack) {
            Icon(Icons.Default.ArrowBack, "Назад")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Рука дилера
        DealerHandView(
            hand = dealerHand,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        // Рука игрока
        PlayerHandView(
            hand = playerHand,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Кнопки управления
        when (gameState) {
            is GameState.Initial -> {
                Button(
                    onClick = { viewModel.startNewGame() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text("Начать игру", style = MaterialTheme.typography.titleMedium)
                }
            }
            is GameState.PlayerTurn -> {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { viewModel.playerHit() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                    ) {
                        Text("Ещё", style = MaterialTheme.typography.titleMedium)
                    }
                    Button(
                        onClick = { viewModel.playerStand() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                    ) {
                        Text("Хватит", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
            is GameState.DealerTurn -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        "Ход дилера...",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            else -> {}
        }
    }
}


//@Composable
//fun GameScreen(modifier: Modifier = Modifier) {
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(Color.Green)
//            .padding(horizontal = 16.dp, vertical = 24.dp)
//    ) {
//        Row(
//            Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text("Счет: 15")
//            Text("Игрок: Иван")
//        }
//        Spacer(Modifier.height(32.dp))
//        Row(
//            Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceAround
//        ) {
//            // Здесь Image/card graphics
//            DynamicOverlappingCards(
//                cardResIds = listOf(
//                    R.drawable.img_6c,
//                    R.drawable.img_6d
//                    ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                cardHeightDp = 100
//            )
//        }
//        Spacer(Modifier.height(32.dp))
//        Row(
//            Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = {  }) { Text("Карта") }
//            Button(onClick = {  }) { Text("Стоп") }
//            Button(onClick = {  }) { Text("Новая игра") }
//        }
//    }
//
//}

//@Preview(showBackground = true)
//@Composable
//fun GameScreenPreview() {
//    GameScreen()
//}