package com.ttsh.carbonwallet.presentation.screens.registerscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ttsh.carbonwallet.presentation.screens.loginscreen.LoginEvent
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationCheckbox
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationLogo
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationTextField
import com.ttsh.carbonwallet.presentation.sharedcomponents.TextFieldType
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.PrimaryGreen

@Composable
fun RegisterScreen(toLogin: () -> Unit, toHome: () -> Unit, viewModel: RegisterViewModel = hiltViewModel()) {
    val uiState = viewModel.registerUiState.collectAsStateWithLifecycle()
    val formPadding = remember {20.dp}
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp )) {
            ApplicationLogo()
            Text(text = "Register" , fontWeight = FontWeight.Bold, color = Primary, fontSize = 22.sp    )
            Text(text = "Start tracking today!", fontWeight = FontWeight.SemiBold)

            Spacer(modifier = androidx.compose.ui.Modifier.height(formPadding))
            ApplicationTextField(value = uiState.value.email , onValueChange = {
                viewModel.onEvent(RegisterEvent.ChangeEmailField(it))
            }, title ="Email" )
            ApplicationTextField(value = uiState.value.password , onValueChange = {

                viewModel.onEvent(RegisterEvent.ChangePasswordField(it) )
            }, title ="Password", textFieldType = TextFieldType.Password )
            ApplicationTextField(value = uiState.value.confirmPassword, onValueChange = {
                println(it)
                viewModel.onEvent(RegisterEvent.ChangeConfirmPasswordField(it))
            } , title = "Confirm password", textFieldType = TextFieldType.Password)
            Spacer(modifier = Modifier.height(formPadding))
            ApplicationButton(text = "Register", onClick = toHome)
            TextButton(onClick =  toLogin, colors = ButtonDefaults.textButtonColors(contentColor = Color.Black)) {
                Text(fontWeight = FontWeight.SemiBold,text = buildAnnotatedString {
                    this.append("Already have an account? ")
                    this.withStyle(style = SpanStyle(color = PrimaryGreen)) {
                        this.append("Login")
                    }
                })
            }



        }

    }
}