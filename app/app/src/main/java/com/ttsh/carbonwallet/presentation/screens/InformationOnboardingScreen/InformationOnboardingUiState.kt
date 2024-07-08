package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import com.ttsh.carbonwallet.presentation.utils.ScreenStatus

data class InformationOnboardingUiState(
    val screenStatus: ScreenStatus,
    val pagerOnboardingItems: List<PagerOnboardingItemState>,
    var currentPage: Int //?
)