package ru.sicampus.bootcamp2026.domain

class CheckRegistrationFormatUseCase {
    operator fun invoke(
        name: String,
        login: String,
        password: String
    ): Boolean {
        return name.isNotBlank() && 
               login.length > 2 && 
               password.length > 5
    }
}
