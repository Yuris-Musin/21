package ru.musindev.ochko.ui.menu

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
import androidx.hilt.navigation.compose.hiltViewModel
import ru.musindev.ochko.ui.viewmodel.MenuViewModel

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = hiltViewModel(),
    onNavigateToGame: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "21 (Очко)",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onNavigateToGame,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Играть")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToSettings,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Настройки")
        }
    }
}
