package ru.sicampus.bootcamp2026.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.sicampus.bootcamp2026.screens.AuthScreen
import ru.sicampus.bootcamp2026.screens.RegistrationScreen
import ru.sicampus.bootcamp2026.screens.ProfileScreen
import ru.sicampus.bootcamp2026.screens.MainScreen
import ru.sicampus.bootcamp2026.screens.InvitingScreen
import ru.sicampus.bootcamp2026.screens.ScheduleScreen

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
        composable(Routes.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Routes.Home.route) {
            MainScreen(navController = navController)
        }
        composable(Routes.Invitations.route) {
            InvitingScreen(navController = navController)
        }
        composable(Routes.Schedule.route) {
            ScheduleScreen(navController = navController)
        }
    }
}

sealed class Routes(val route: String) {
    object Auth : Routes("auth")
    object Registration : Routes("registration")
    object Profile : Routes("profile")
    object Invitations : Routes("invitations")
    object Home : Routes("home")
    object Schedule : Routes("schedule")
}