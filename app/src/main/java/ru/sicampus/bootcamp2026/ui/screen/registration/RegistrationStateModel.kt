package ru.sicampus.bootcamp2026.ui.screen.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.delay

class RegistrationStateModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update { it.copy(name = name, error = null) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, error = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, error = null) }
    }

    fun onRegisterClick() {
        val currentState = _uiState.value
        if (currentState.name.isBlank() || currentState.email.isBlank() || currentState.password.isBlank()) {
            _uiState.update { it.copy(error = "Пожалуйста, заполните все поля") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            
            // Имитация регистрации
            delay(1000)

            if (currentState.email.contains("@") && currentState.password.length >= 4) {
                _uiState.update { it.copy(isLoading = false, isRegistered = true) }
            } else {
                _uiState.update { it.copy(isLoading = false, error = "Ошибка регистрации. Проверьте данные.") }
            }
        }
    }
}
