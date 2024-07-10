package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import com.ttsh.carbonwallet.presentation.utils.ScreenStatus

data class InformationOnboardingUiState(
    val status: ScreenStatus,
    val pagerOnboardingItems: List<PagerOnboardingItemState>,
    var currentPage: Int //?
)