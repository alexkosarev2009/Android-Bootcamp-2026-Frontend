package ru.sicampus.bootcamp2026.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainStateModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainState())
    val uiState = _uiState.asStateFlow()

    fun onMeetingNameChange(name: String) {
        _uiState.update { it.copy(meetingName = name) }
    }

    fun onMeetingDateChange(date: String) {
        _uiState.update { it.copy(meetingDate = date) }
    }

    fun onMeetingTimeChange(time: String) {
        _uiState.update { it.copy(meetingTime = time) }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onCreateMeetingClick() {
        // Logic for creating a meeting
    }

    fun getData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // Logic will be added later
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
