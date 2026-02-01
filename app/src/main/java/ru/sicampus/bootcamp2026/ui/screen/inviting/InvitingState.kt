package ru.sicampus.bootcamp2026.ui.screen.inviting

sealed interface InvitingState {
    data class Error(val reason: String) : InvitingState
    data object Loading : InvitingState
    data object Content : InvitingState
}
