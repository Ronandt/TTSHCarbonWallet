package com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen

import android.util.Size
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationDescription
import com.ttsh.carbonwallet.presentation.theme.DescriptionGray
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.SecondaryGray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InformationOnboardingScreen(viewModel: InformationOnboardingViewModel = hiltViewModel(), scope: CoroutineScope, onNext: () -> Unit) {
    val pagerState = rememberPagerState()
    val uiState = viewModel.informationOnboardingUiState.collectAsStateWithLifecycle()
    val pagerList = uiState.value.pagerOnboardingItems
    Column() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
           TextButton(onClick = {
               scope.launch {
                   pagerState.animateScrollToPage(pagerList.size-1)
               }


           }) {
               Text(text = "Skip", fontWeight = FontWeight.SemiBold, color = Color.Black)
           }
        }
        ApplicationColumn(verticalArrangement = Arrangement.spacedBy(10.dp  )) {
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalPager(pageCount =    uiState.value.pagerOnboardingItems.size, state = pagerState) {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp, alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(pagerList[it].image, contentDescription = pagerList[it].header , modifier = Modifier.size(250.dp ), contentScale = ContentScale.Crop)
                    Text(text = pagerList[it].header, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, textAlign = TextAlign.Center)
                    ApplicationDescription(
                        text = pagerList[it].description,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(250.dp)
                    )
                }
                uiState.value.pagerOnboardingItems[it]
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp   )) {
                val spacerSize = remember { 12.dp}
                pagerList.forEachIndexed {indx, value ->

                    if(indx != pagerState.currentPage)  {
                        Spacer(modifier = Modifier
                            .size(spacerSize)
                            .background(color = SecondaryGray, shape = CircleShape))
                    } else {
                        Spacer(modifier = Modifier
                            .size(width = spacerSize + 16.dp, spacerSize)
                            .background(color = Primary, shape = CircleShape))
                    }

                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            AnimatedVisibility(visible =pagerState.currentPage == pagerList.size-1 ) {
                ApplicationButton(text = "Get Started!", onClick = {
                    onNext()

                })
            }

        }

    }
}