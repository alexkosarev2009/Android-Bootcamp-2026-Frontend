package ru.sicampus.bootcamp2026.ui.screen.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScheduleStateModel : ViewModel() {
    private val _uiState: MutableStateFlow<ScheduleState> = MutableStateFlow(ScheduleState.Content)
    val uiState = _uiState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            _uiState.emit(ScheduleState.Loading)
            _uiState.emit(ScheduleState.Content)
        }
    }
}
