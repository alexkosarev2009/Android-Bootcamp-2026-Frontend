package ru.sicampus.bootcamp2026.data.source

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object AuthLocalDataSource {
    private val TOKEN_KEY = stringPreferencesKey("auth_token")
    private var appContext: Context? = null

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    var token: String?
        get() = runBlocking {
            appContext?.dataStore?.data?.map { it[TOKEN_KEY] }?.first()
        }
        private set(value) {
            runBlocking {
                appContext?.dataStore?.edit { it[TOKEN_KEY] = value ?: "" }
            }
        }

    @OptIn(ExperimentalEncodingApi::class)
    fun setToken(login: String, password: String) {
        val decodePhace = "$login:$password"
        token = "Basic ${Base64.encode(decodePhace.toByteArray())}"
    }

    fun clearToken() {
        token = null
    }
}
