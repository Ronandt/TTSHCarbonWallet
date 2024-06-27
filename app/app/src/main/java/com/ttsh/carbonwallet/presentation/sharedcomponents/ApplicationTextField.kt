package com.ttsh.carbonwallet.presentation.sharedcomponents


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.theme.Primary

enum class TextFieldType {
    Normal,
    Password
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTextField(value: String, onValueChange: (String) -> Unit, title: String ,textFieldType: TextFieldType = TextFieldType.Normal , modifier: Modifier = Modifier) {
    var hidePassword by remember {mutableStateOf(false)}
  OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Primary, focusedLabelColor = Primary), value = value, onValueChange = onValueChange, label = {
    Text(text = title)
    }, modifier = Modifier
      .fillMaxWidth()
      .then(modifier), trailingIcon = {
            if(textFieldType == TextFieldType.Password) {
                IconButton(onClick = { hidePassword = !hidePassword}) {
                    Icon(painter = painterResource(id = if(hidePassword ) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription ="Hide password" )
                }

            }

    }, visualTransformation = if(hidePassword) PasswordVisualTransformation() else  VisualTransformation.None)



}