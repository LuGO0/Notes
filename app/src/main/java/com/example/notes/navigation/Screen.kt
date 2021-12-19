package com.example.notes.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen ("main_screen")
    object DetailScreen : Screen ("detail_screen")
}
