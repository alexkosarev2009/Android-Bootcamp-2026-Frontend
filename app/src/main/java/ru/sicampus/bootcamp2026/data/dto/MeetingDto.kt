package ru.sicampus.bootcamp2026.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeetingDto(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("date")
    val date: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("creator_id")
    val creatorId: String?
)

@Serializable
data class CreateMeetingRequestDto(
    @SerialName("name")
    val name: String,
    @SerialName("date")
    val date: String,
    @SerialName("time")
    val time: String
)
