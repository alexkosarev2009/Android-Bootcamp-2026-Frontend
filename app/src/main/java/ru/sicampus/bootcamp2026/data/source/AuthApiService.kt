package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import ru.sicampus.bootcamp2026.data.dto.AuthResponseDto
import ru.sicampus.bootcamp2026.data.dto.LoginRequestDto
import ru.sicampus.bootcamp2026.data.dto.RegistrationRequestDto

class AuthApiService {
    private val client = Network.client

    suspend fun login(request: LoginRequestDto): AuthResponseDto {
        return client.post("${Network.HOST}/auth/login") {
            setBody(request)
        }.body()
    }

    suspend fun register(request: RegistrationRequestDto): AuthResponseDto {
        return client.post("${Network.HOST}/auth/register") {
            setBody(request)
        }.body()
    }
}
