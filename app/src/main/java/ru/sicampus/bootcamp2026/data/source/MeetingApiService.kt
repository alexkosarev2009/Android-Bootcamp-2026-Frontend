package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import ru.sicampus.bootcamp2026.data.dto.MeetingDto
import ru.sicampus.bootcamp2026.data.dto.CreateMeetingRequestDto

class MeetingApiService {
    private val client = Network.client

    suspend fun getMeetings(): List<MeetingDto> {
        return client.get("${Network.HOST}/meetings").body()
    }

    suspend fun createMeeting(request: CreateMeetingRequestDto): MeetingDto {
        return client.post("${Network.HOST}/meetings") {
            setBody(request)
        }.body()
    }
}
