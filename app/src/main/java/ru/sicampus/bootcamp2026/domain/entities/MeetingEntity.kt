package ru.sicampus.bootcamp2026.domain.entities

data class MeetingEntity(
    val id: String,
    val name: String,
    val date: String,
    val time: String,
    val creatorId: String
)
