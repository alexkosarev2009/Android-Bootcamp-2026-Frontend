package ru.sicampus.bootcamp2026.data.source

import android.util.Log
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sicampus.bootcamp2026.data.dto.UserDto
import kotlinx.coroutines.delay

class UserInfoDataSource {
    suspend fun getUser(): Result<List<UserDto>> = withContext(Dispatchers.IO) {
        runCatching {
            delay(1500L)

            try {
                val response = Network.client.get("${Network.HOST}/api/person")
                if (response.status == HttpStatusCode.OK) {
                    return@runCatching response.body<List<UserDto>>()
                }
            } catch (e: Exception) {
                Log.e("UserInfoDataSource", "Real request failed", e)
            }

            listOf(
                UserDto(name = "Иван Иванов", password = "hashed_password_1"),
                UserDto(name = "Петр Петров", password = "hashed_password_2"),
                UserDto(name = "Мария Сидорова", password = "hashed_password_3")
            )
        }
    }
}