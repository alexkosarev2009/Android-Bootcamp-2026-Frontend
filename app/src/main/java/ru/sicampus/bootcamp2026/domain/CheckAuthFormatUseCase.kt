package ru.sicampus.bootcamp2026.domain

class CheckAuthFormatUseCase {
    operator fun invoke(
        login: String,
        password: String
    ): Boolean {
        return login.length > 2 && login.all { char ->
            (char in 'A'..'Z') || (char in 'a'..'z') || (char in '0'..'9')
        } && password.isNotBlank()
    }
}