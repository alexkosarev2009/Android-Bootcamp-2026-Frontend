package ru.sicampus.bootcamp2026.domain


import ru.sicampus.bootcamp2026.data.UserRepository
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.UserApiService
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

class GetUsersUseCase (
    private val userRepository : UserRepository = UserRepository(
        UserApiService(),
        AuthLocalDataSource
    )
){
    suspend operator fun invoke(
        page: Int
    ): Result<List<UserEntity>>{
        return userRepository.getUsers(
            page = page,
            size = COUNT,
        )
    }

    private companion object {
        const val  COUNT = 5
    }
}