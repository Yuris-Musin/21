package ru.musindev.ochko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.musindev.ochko.ui.screen.SettingsScreen
import ru.musindev.ochko.ui.theme.OchkoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OchkoTheme {
                SettingsScreen()
            }
        }
    }
}
