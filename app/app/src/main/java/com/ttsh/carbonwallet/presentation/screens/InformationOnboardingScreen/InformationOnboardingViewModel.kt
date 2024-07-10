package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import androidx.lifecycle.ViewModel
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.screens.registerscreen.RegisterUiState
import com.ttsh.carbonwallet.presentation.utils.ScreenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class InformationOnboardingViewModel @Inject constructor(): ViewModel() {
    private val _informationOnboardingUiState = MutableStateFlow(InformationOnboardingUiState(status = ScreenStatus.Success(), currentPage = 0, pagerOnboardingItems = listOf(
        PagerOnboardingItemState("Learn Eco-Friendliness",
            "Choose greener alternatives to reduce your carbon footprint", R.drawable.stop_air_pollution_carbon_dioxide ),
        PagerOnboardingItemState("Earn Rewards",
            "Earn valuable rewards and points by trakcing your carbon use", R.drawable.happy_woman_receiving_gift),
        PagerOnboardingItemState("Track your carbon",
            "Track your carbon expenditure, and know your carbon impact", R.drawable.icon_individual)

    ) ))
    val informationOnboardingUiState = _informationOnboardingUiState.asStateFlow()

}