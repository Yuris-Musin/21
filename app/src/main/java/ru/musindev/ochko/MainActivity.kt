package ru.musindev.ochko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.musindev.ochko.ui.navigation.NavGraph
import ru.musindev.ochko.ui.theme.OchkoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OchkoTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
