package com.ttsh.carbonwallet.presentation.screens.loginscreen

import androidx.lifecycle.ViewModel
import com.ttsh.carbonwallet.presentation.screens.splashscreen.SplashUiState
import com.ttsh.carbonwallet.presentation.utils.ScreenStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUiState(status = ScreenStatus.Success(), email = "", password = "", keepSignedIn = false  ))
    val loginUiState = _loginUiState.asStateFlow()


    fun onEvent(loginEvent: LoginEvent) {
        when(loginEvent) {
           is LoginEvent.ChangeEmailField -> {
               _loginUiState.update {
                   it.copy(email = loginEvent.email)
               }
            }
            is LoginEvent.ChangePasswordField -> {
                _loginUiState.update {
                    it.copy(password = loginEvent.password)
                }
            }
            is LoginEvent.ToggleKeepSignedIn -> {
                _loginUiState.update {
                    it.copy(keepSignedIn  = loginEvent.keepSignedIn)
                }
            }

        }
    }


}