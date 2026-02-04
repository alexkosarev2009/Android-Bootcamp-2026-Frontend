package ru.sicampus.bootcamp2026.domain


import ru.sicampus.bootcamp2026.data.UserRepository
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.UserInfoDataSource
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

class GetUsersUseCase (
    private val userRepository : UserRepository = UserRepository(
        UserInfoDataSource(),
        AuthLocalDataSource
    )
){
    suspend operator fun invoke(): Result<List<UserEntity>>{
        return userRepository.getUsers()
    }
}