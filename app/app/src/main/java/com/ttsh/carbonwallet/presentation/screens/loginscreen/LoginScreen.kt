package com.ttsh.carbonwallet.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationCheckbox
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationLogo
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationTextField
import com.ttsh.carbonwallet.presentation.sharedcomponents.TextFieldType
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.PrimaryGreen

@Composable
fun LoginScreen(toRegister: () -> Unit, onAuthenticated: () -> Unit, viewModel: LoginViewModel = hiltViewModel()) {
    val uiState =  viewModel.loginUiState.collectAsStateWithLifecycle()
    val formPadding = remember  {20.dp}
Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp )) {
        ApplicationLogo()
        Text(text = "Login", fontWeight = FontWeight.Bold, color = Primary, fontSize = 22.sp    )
        Text(text = "Start tracking today!", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(formPadding))
        ApplicationTextField(value = uiState.value.email , onValueChange = {
            viewModel.onEvent(LoginEvent.ChangeEmailField(it))
        }, title ="Email" )
        ApplicationTextField(value = uiState.value.password , onValueChange = {

            viewModel.onEvent(LoginEvent.ChangePasswordField(it))
        }, title ="Password", textFieldType = TextFieldType.Password )

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start ), verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            ApplicationCheckbox(checked = uiState.value.keepSignedIn, onCheckedChange = {
                viewModel.onEvent(LoginEvent.ToggleKeepSignedIn(it))
            })
            Text(text = "Keep me signed in")
        }
        Spacer(modifier = Modifier.height(formPadding/2))
        ApplicationButton(text = "Login", onClick = onAuthenticated)
        Spacer(modifier = Modifier.height(formPadding))
        TextButton(onClick =  toRegister, colors = androidx.compose.material3.ButtonDefaults.textButtonColors(contentColor = Color.Black)) {
            Text(fontWeight = FontWeight.SemiBold,text = buildAnnotatedString {
                this.append("Don't have an account? ")
                this.withStyle(style = SpanStyle(color = PrimaryGreen)) {
                    this.append("Register")
                }
            })
        }



    }

}
}