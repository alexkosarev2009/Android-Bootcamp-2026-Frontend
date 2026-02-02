package ru.sicampus.bootcamp2026.ui.screen.registration

data class RegistrationState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRegistered: Boolean = false
)
