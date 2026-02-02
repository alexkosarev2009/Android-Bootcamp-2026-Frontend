package ru.sicampus.bootcamp2026.ui.screen.schedule

sealed interface ScheduleState {
    data class Error(val reason: String) : ScheduleState
    data object Loading : ScheduleState
    data object Content : ScheduleState
}
