package ru.sicampus.bootcamp2026.ui.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class AuthStateModel: ViewModel() {
    private val _uiState = MutableStateFlow(AuthState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, error = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, error = null) }
    }

    fun onLoginClick() {
        val currentState = _uiState.value
        if (currentState.email.isBlank() || currentState.password.isBlank()) {
            _uiState.update { it.copy(error = "Пожалуйста, заполните все поля") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            
            // Имитация запроса к серверу
            delay(1000)

            // Моковая проверка (принимаем любого пользователя для теста)
            // В реальности здесь будет вызов UseCase
            if (currentState.email.contains("@") && currentState.password.length >= 4) {
                _uiState.update { it.copy(isLoading = false, isAuthorized = true) }
            } else {
                _uiState.update { it.copy(isLoading = false, error = "Неверный email или пароль") }
            }
        }
    }
}