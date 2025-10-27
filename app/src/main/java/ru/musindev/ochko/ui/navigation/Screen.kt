package ru.musindev.ochko.ui.navigation

sealed class Screen(val route: String) {
    object Menu : Screen("menu")
    object Game : Screen("game")
    object Settings : Screen("settings")
    object GameOver : Screen("game_over/{result}") {
        fun createRoute(result: String) = "game_over/$result"
    }
}
