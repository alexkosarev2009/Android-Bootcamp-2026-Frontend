 package ru.sicampus.bootcamp2026.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseDto(
    @SerialName("token")
    val token: String?,
    @SerialName("user")
    val user: UserDto?
)

@Serializable
data class RegistrationRequestDto(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String? = null
)
