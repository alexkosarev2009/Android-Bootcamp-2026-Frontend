package ru.sicampus.bootcamp2026.data.mappers

import ru.sicampus.bootcamp2026.data.dto.UserDto
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        id = id ?: "",
        name = name ?: "Unknown",
        email = email
    )
}
