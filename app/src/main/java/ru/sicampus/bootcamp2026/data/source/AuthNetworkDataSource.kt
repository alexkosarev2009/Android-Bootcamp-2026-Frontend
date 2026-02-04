package ru.sicampus.bootcamp2026.data.source

import android.util.Log
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthNetworkDataSource {
    suspend fun checkAuth(token: String): Boolean = withContext(Dispatchers.IO) {
        runCatching {
            val result = Network.client.get("${Network.HOST}/api/login") {
                header(HttpHeaders.Authorization, token)
            }
            result.status == HttpStatusCode.OK
        }.getOrElse { 
            Log.e("AuthNetworkDataSource", "Auth check failed", it)
            false 
        }
    }
}
