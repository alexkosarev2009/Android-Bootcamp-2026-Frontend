package ru.sicampus.bootcamp2026.data

import ru.sicampus.bootcamp2026.data.mappers.toEntity
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.UserInfoDataSource
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

class UserRepository(
    private val userInfoDataSource: UserInfoDataSource,
    private val authLocalDataSource: AuthLocalDataSource
){
    suspend fun getUsers(): Result<List<UserEntity>>{
        val token = authLocalDataSource.token ?: return Result.failure(Exception("No auth token"))
        return userInfoDataSource.getUser(token).map { listDto ->
            listDto.map { it.toEntity() }
        }
    }
}