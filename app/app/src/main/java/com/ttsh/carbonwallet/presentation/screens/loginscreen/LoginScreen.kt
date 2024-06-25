package com.ttsh.carbonwallet.presentation.screens.loginscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttsh.carbonwallet.presentation.theme.Primary

@Composable
fun LoginScreen() {
Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp ), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Login", fontWeight = FontWeight.Bold, color = Primary, fontSize = 22.sp    )
        Text(text = "Start tracking today!", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))



    }

}
}