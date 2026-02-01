package ru.sicampus.bootcamp2026.ui.screen.inviting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InvitingStateModel : ViewModel() {
    private val _uiState: MutableStateFlow<InvitingState> = MutableStateFlow(InvitingState.Content)
    val uiState = _uiState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            _uiState.emit(InvitingState.Loading)
            // Logic will be added later
            _uiState.emit(InvitingState.Content)
        }
    }
}
