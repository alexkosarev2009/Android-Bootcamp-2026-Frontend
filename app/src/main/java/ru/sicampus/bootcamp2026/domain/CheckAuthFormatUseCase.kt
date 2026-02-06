package ru.sicampus.bootcamp2026.domain

class CheckAuthFormatUseCase {
    operator fun invoke(
        email: String,
        password: String
    ): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        return email.matches(emailRegex) && password.isNotBlank()
    }
}