package com.ttsh.carbonwallet.presentation.screens.registerscreen

import com.ttsh.carbonwallet.presentation.utils.ScreenStatus

data class RegisterUiState(
    val email: String,
    val password: String,
    val confirmPassword: String,
    val status: ScreenStatus
)
