package ru.sicampus.bootcamp2026.domain

import ru.sicampus.bootcamp2026.data.AuthRepository
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.AuthNetworkDataSource

class RegisterUseCase(
    private val authRepository: AuthRepository = AuthRepository(
        AuthNetworkDataSource(),
        AuthLocalDataSource
    )
) {
    suspend operator fun invoke(
        login: String,
        password: String,
        name: String,
        email: String? = null
    ): Result<Unit> {
        if (login.isBlank() || password.isBlank() || name.isBlank()) {
            return Result.failure(Exception("Поля не могут быть пустыми"))
        }
        return authRepository.register(login, password, name, email)
    }
}
