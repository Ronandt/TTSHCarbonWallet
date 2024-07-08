package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InformationOnboardingScreen(viewModel: InformationOnboardingViewModel = hiltViewModel(), scope: CoroutineScope) {
    val pagerState = rememberPagerState()
    val uiState = viewModel.informationOnboardingUiState.collectAsStateWithLifecycle()
    val pagerList = uiState.value.pagerOnboardingItems
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
           TextButton(onClick = {
               scope.launch {
                   pagerState.animateScrollToPage(pagerList.size-1)
               }


           }) {
               Text(text = "Skip", fontWeight = FontWeight.SemiBold, color = Color.Black)
           }
        }
        ApplicationColumn {
            HorizontalPager(pageCount =    uiState.value.pagerOnboardingItems.size, state = pagerState) {
                Column(verticalArrangement = Arrangement.Center) {
                    AsyncImage(pagerList[it].image, contentDescription = pagerList[it].header , modifier = Modifier.size(200.dp ), contentScale = ContentScale.Crop)
                    Text(text = pagerList[it].header, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, textAlign = TextAlign.Center)
                    Text(text = pagerList[it].description, textAlign = TextAlign.Center)
                }
                uiState.value.pagerOnboardingItems[it]
            }
        }
    }
}