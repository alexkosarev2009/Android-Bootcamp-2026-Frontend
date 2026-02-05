package ru.sicampus.bootcamp2026

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.NavGraph


@Composable
fun App(
) {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}