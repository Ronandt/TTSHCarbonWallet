package com.ttsh.carbonwallet.presentation.screens.splashscreen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(text: String) {
    Text(text = text, fontWeight = FontWeight.Bold, color = Color.White, fontSize = 24.sp)
}