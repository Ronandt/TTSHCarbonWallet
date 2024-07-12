package com.ttsh.carbonwallet.presentation.screens.splashscreen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.screens.splashscreen.components.Title
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.PrimaryGreen
import com.ttsh.carbonwallet.presentation.utils.ScreenStatus

@Composable
fun SplashScreen(onNavigate: () -> Unit, viewModel:SplashViewModel=  hiltViewModel())  {
    val uiState = viewModel.splashUiState.collectAsStateWithLifecycle()


    LaunchedEffect(uiState.value) {
        if(uiState.value.status is ScreenStatus.Success) {
            onNavigate()
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(painter = painterResource(id = R.drawable.wallet_icon), contentDescription = "Wallet", modifier = Modifier.size(100.dp ) )
            Title(text = "Carbon Wallet")
            LinearProgressIndicator(color = PrimaryGreen)
        }
    }
}