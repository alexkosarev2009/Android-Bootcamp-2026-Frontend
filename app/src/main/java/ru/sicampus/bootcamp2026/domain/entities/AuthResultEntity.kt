package ru.sicampus.bootcamp2026.domain.entities

data class AuthResultEntity(
    val token: String,
    val user: UserEntity
)
