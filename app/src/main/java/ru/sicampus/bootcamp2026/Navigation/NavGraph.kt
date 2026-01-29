package ru.sicampus.bootcamp2026.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.sicampus.bootcamp2026.screens.AuthScreen
import ru.sicampus.bootcamp2026.screens.RegistrationScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Auth.route
    ) {
        composable(Routes.Auth.route) {
            AuthScreen(navHostController = navController)
        }
        composable(Routes.Registration.route) {
            RegistrationScreen(navHostController = navController)
        }
    }
}

sealed class Routes(val route: String) {
    object Auth : Routes("auth")
    object Registration : Routes("registration")
}