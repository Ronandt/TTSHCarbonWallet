package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InformationOnboardingScreen(viewModel: InformationOnboardingViewModel = hiltViewModel()) {
    var pagerState = rememberPagerState()

    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
           TextButton(onClick = { /*TODO*/ }) {
               Text(text = "Skip", fontWeight = FontWeight.SemiBold)
           }
        }
        ApplicationColumn {
            HorizontalPager(pageCount =  0) {

            }
        }
    }
}