package ru.musindev.ochko.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.musindev.ochko.ui.menu.MenuScreen
import ru.musindev.ochko.ui.screen.GameOverScreen
import ru.musindev.ochko.ui.screen.GameScreen
import ru.musindev.ochko.ui.screen.SettingsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Menu.route,
        modifier = modifier
    ) {
        composable(Screen.Menu.route) {
            MenuScreen(
                onNavigateToGame = { navController.navigate(Screen.Game.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) }
            )
        }

        composable(Screen.Game.route) {
            GameScreen(
                onNavigateBack = { navController.navigateUp() },
                onNavigateToGameOver = { result ->
                    navController.navigate(Screen.GameOver.createRoute(result))
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = Screen.GameOver.route,
            arguments = listOf(navArgument("result") { type = NavType.StringType })
        ) { backStackEntry ->
            val result = backStackEntry.arguments?.getString("result") ?: ""
            GameOverScreen(
                result = result,
                onPlayAgain = {
                    navController.navigate(Screen.Game.route) {
                        popUpTo(Screen.Menu.route)
                    }
                },
                onNavigateToMenu = {
                    navController.navigate(Screen.Menu.route) {
                        popUpTo(Screen.Menu.route) { inclusive = true }
                    }
                }
            )
        }
    }
}


