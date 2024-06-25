package com.ttsh.carbonwallet.presentation.screens.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttsh.carbonwallet.presentation.utils.ScreenStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {
    private val _splashUiState = MutableStateFlow(SplashUiState(screenTimeInMilliseconds = 1000L, status = ScreenStatus.Loading))
    val splashUiState = _splashUiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(splashUiState.value.screenTimeInMilliseconds)
            onLoaded()
        }
    }
    private fun onLoaded() {
        _splashUiState.update {
            splashUiState ->  splashUiState.copy(status = ScreenStatus.Success())
        }

    }
}