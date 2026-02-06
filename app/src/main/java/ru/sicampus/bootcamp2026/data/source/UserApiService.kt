package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.sicampus.bootcamp2026.data.dto.UserDto

class UserApiService {
    private val client = Network.client

    suspend fun getUsers(): List<UserDto> {
        return client.get("${Network.HOST}/api/users").body()
    }
}
