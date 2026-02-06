package ru.sicampus.bootcamp2026.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileStateModel : ViewModel() {
    private val _uiState: MutableStateFlow<ProfileState> = MutableStateFlow(ProfileState.Content)
    val uiState = _uiState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            _uiState.emit(ProfileState.Loading)
            _uiState.emit(ProfileState.Content)
        }
    }
}
