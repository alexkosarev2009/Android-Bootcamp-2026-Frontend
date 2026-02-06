package ru.sicampus.bootcamp2026.data

import ru.sicampus.bootcamp2026.data.mappers.toEntity
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.UserApiService
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

class UserRepository(
    private val apiService: UserApiService = UserApiService(),
    private val authLocalDataSource: AuthLocalDataSource
){
    suspend fun getUsers(page: Int = 0, size: Int = 20): Result<List<UserEntity>>{
        return try {
            val users = apiService.getUsers()
            Result.success(users.map { it.toEntity() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}