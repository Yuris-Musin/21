package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("21 очко", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(40.dp))
        Button(onClick = {  }) { Text("Играть") }
        Spacer(Modifier.height(16.dp))
        Button(onClick = {  }) { Text("Настройки") }
        Spacer(Modifier.height(16.dp))
        Button(onClick = {  }) { Text("О игре") }
        Spacer(Modifier.height(32.dp))
        Text("Рекорд: 21", style = MaterialTheme.typography.bodyLarge)
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}