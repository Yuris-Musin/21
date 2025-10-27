package ru.musindev.ochko.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {

    var isDark by remember { mutableStateOf(false) }
    var isSoundOn by remember { mutableStateOf(false) }

    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Легко", "Средне", "Сложно")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Настройки", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Темная тема")
            Switch(checked = isDark, onCheckedChange = {  })
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Звук")
            Switch(checked = isSoundOn, onCheckedChange = {  })
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Сложность")
            Box {
                Button(onClick = { expanded = true }) {
                    Text(selectedOption)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(label) },
                            onClick = {
                                selectedOption = label
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        Button(onClick = {  }) { Text("Назад") }
    }

}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}