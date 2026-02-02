package ru.sicampus.bootcamp2026.domain.entities

import kotlinx.serialization.SerialName

data class UserEntity(
    val id: String,
    val name: String,
    val email: String? = null
)