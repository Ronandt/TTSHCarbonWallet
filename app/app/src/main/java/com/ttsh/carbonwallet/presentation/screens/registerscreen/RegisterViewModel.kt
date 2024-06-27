package com.ttsh.carbonwallet.presentation.screens.registerscreen

import androidx.lifecycle.ViewModel
import com.ttsh.carbonwallet.presentation.screens.loginscreen.LoginEvent
import com.ttsh.carbonwallet.presentation.screens.loginscreen.LoginUiState
import com.ttsh.carbonwallet.presentation.utils.ScreenStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    private val _registerUiState = MutableStateFlow(RegisterUiState(status = ScreenStatus.Success(), email = "", password = "", confirmPassword = "" ))
    val registerUiState = _registerUiState.asStateFlow()


    fun onEvent(registerEvent:  RegisterEvent) {
        when(registerEvent) {
            is RegisterEvent.ChangeEmailField -> {
                _registerUiState.update {
                    it.copy(email = it.email)
                }
            }
            is RegisterEvent.ChangeConfirmPasswordField -> {
                _registerUiState.update {
                    it.copy(password= it.password)
                }
            }
            is RegisterEvent.ChangePasswordField-> {
                _registerUiState.update {
                    it.copy(confirmPassword = it.confirmPassword)
                }
            }


        }
    }


}