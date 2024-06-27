package com.ttsh.carbonwallet.presentation.screens.registerscreen

sealed class RegisterEvent {
    data class ChangeEmailField(val email: String): RegisterEvent()
    data class ChangePasswordField(val password: String): RegisterEvent()
    data class ChangeConfirmPasswordField(val confirmPassword: String): RegisterEvent()
}