package com.ttsh.carbonwallet.presentation.utils

sealed class ScreenStatus {
    object Loading: ScreenStatus()
    data class Success(val message: String = "") : ScreenStatus()
    data class Error(val exception: String) : ScreenStatus()
}