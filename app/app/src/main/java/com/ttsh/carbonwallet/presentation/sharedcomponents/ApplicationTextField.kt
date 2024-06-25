package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class TextFieldType {
    Normal,
    Password
}

@Composable
fun ApplicationTextField(value: String, onValueChange: (String) -> Unit, title: String,textFieldType: TextFieldType = TextFieldType.Normal , modifier: Modifier = Modifier) {
    OutlinedTextField(value = value, onValueChange = onValueChange, label = {
        Text(text = title)
    }, modifier = Modifier
        .fillMaxWidth()
        .then(modifier))

}