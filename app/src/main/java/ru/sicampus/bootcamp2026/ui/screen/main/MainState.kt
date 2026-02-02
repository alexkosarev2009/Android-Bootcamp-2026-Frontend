package ru.sicampus.bootcamp2026.ui.screen.main

data class MainState(
    val meetingName: String = "",
    val meetingDate: String = "",
    val meetingTime: String = "",
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
