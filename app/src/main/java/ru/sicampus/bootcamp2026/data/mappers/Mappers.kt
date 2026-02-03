package ru.sicampus.bootcamp2026.data.mappers

import ru.sicampus.bootcamp2026.data.dto.UserDto
import ru.sicampus.bootcamp2026.data.dto.MeetingDto
import ru.sicampus.bootcamp2026.data.dto.AuthResponseDto
import ru.sicampus.bootcamp2026.domain.entities.UserEntity
import ru.sicampus.bootcamp2026.domain.entities.MeetingEntity
import ru.sicampus.bootcamp2026.domain.entities.AuthResultEntity

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        id = id ?: "",
        name = name ?: "Unknown",
        email = email
    )
}

fun MeetingDto.toEntity(): MeetingEntity {
    return MeetingEntity(
        id = id ?: "",
        name = name ?: "Untitled Meeting",
        date = date ?: "",
        time = time ?: "",
        creatorId = creatorId ?: ""
    )
}

fun AuthResponseDto.toEntity(): AuthResultEntity? {
    val userEntity = user?.toEntity() ?: return null
    return AuthResultEntity(
        token = token ?: "",
        user = userEntity
    )
}
