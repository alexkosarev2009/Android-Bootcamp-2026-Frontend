package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sicampus.bootcamp2026.data.dto.UserDto

class UserInfoDataSource {
    suspend fun getUser(token: String): Result<List<UserDto>> = withContext(Dispatchers.IO) {
        runCatching {
            val response = Network.client.get("${Network.HOST}/api/person") {
                header(HttpHeaders.Authorization, token)
            }
            if (response.status == HttpStatusCode.OK) {
                response.body<List<UserDto>>()
            } else {
                throw Exception("Failed to fetch users: ${response.status}")
            }
        }
    }
}
