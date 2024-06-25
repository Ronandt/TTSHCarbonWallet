package com.ttsh.carbonwallet.presentation.screens.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ttsh.carbonwallet.presentation.screens.splashscreen.components.Title
import com.ttsh.carbonwallet.presentation.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onLoaded: () -> Unit, viewModel:SplashViewModel=  hiltViewModel())  {
    LaunchedEffect(Unit) {
        delay(viewModel.screenTimeInMilliseconds)
        onLoaded()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)) {

          Title(text = "Carbon Wallet")
        }
    }
}