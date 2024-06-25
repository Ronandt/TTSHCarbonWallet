package com.ttsh.carbonwallet.presentation.screens.splashscreen

import com.ttsh.carbonwallet.presentation.utils.ScreenStatus


data class SplashUiState(
    val status: ScreenStatus, //Use this when you actually need to load
    val screenTimeInMilliseconds: Long
)
