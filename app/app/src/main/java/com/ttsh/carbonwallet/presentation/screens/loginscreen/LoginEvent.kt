package com.ttsh.carbonwallet.presentation.screens.loginscreen

sealed class LoginEvent {
    data class ChangeEmailField(val email: String): LoginEvent()
    data class ChangePasswordField(val password: String): LoginEvent()
    data class ToggleKeepSignedIn(val keepSignedIn: Boolean): LoginEvent()
}