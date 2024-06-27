package com.ttsh.carbonwallet.presentation.screens.loginscreen

import com.ttsh.carbonwallet.presentation.utils.ScreenStatus

data class LoginUiState(
    val status: ScreenStatus,
    val email: String,
    val password: String,
    val keepSignedIn: Boolean,


)