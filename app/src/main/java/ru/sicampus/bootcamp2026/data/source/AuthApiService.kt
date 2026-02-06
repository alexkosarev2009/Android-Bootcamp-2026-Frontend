package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import ru.sicampus.bootcamp2026.data.dto.AuthResponseDto
import ru.sicampus.bootcamp2026.data.dto.RegistrationRequestDto

class AuthApiService {
    private val client = Network.client

    suspend fun checkAuth(): Boolean {
        return try {
            val response = client.get("${Network.HOST}/api/users")
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            false
        }
    }

    suspend fun register(request: RegistrationRequestDto): AuthResponseDto {
        return client.post("${Network.HOST}/api/users/register") {
            setBody(request)
        }.body()
    }
}
