package com.ttsh.carbonwallet.presentation.sharedcomponents


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.theme.Primary

enum class TextFieldType {
    Normal,
    Password
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTextField(value: String, onValueChange: (String) -> Unit, title: String  ,modifier: Modifier = Modifier,textFieldType: TextFieldType = TextFieldType.Normal , supportingText: String = "") {
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

    }, visualTransformation = if(hidePassword) PasswordVisualTransformation() else  VisualTransformation.None, supportingText = {
        if(supportingText != "") {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp ), verticalAlignment = Alignment.CenterVertically) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Exit"
                )
                Text(
                    text = supportingText
                )
            }

        }
  })



}