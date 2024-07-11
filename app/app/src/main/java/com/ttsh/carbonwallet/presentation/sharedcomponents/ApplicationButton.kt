package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttsh.carbonwallet.presentation.theme.Primary

@Composable
fun ApplicationButton(text: String, onClick: ()->Unit, enabled: Boolean = true, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = Modifier
        .fillMaxWidth()
        .then(modifier), enabled = enabled, colors = ButtonDefaults.buttonColors(containerColor = Primary), shape = RoundedCornerShape(8.dp    )) {
        Text(text = text, fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(4.dp ))
    }
}