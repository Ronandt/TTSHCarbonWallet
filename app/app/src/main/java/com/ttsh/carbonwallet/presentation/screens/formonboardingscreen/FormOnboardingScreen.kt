package com.ttsh.carbonwallet.presentation.screens.formonboardingscreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.screens.formonboardingscreen.subscreens.EnterPersonalDetailsScreen
import com.ttsh.carbonwallet.presentation.screens.formonboardingscreen.subscreens.SelectTransportationScreen
import com.ttsh.carbonwallet.presentation.screens.formonboardingscreen.subscreens.TransportationMode
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationDescription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

enum class SubScreen {
    SelectTransportation,
    EnterPersonalDetails


}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun FormOnboardingScreen(scope: CoroutineScope){
    val pagerState = rememberPagerState()
    val subScreenList = remember {
        listOf(SubScreen.SelectTransportation,
            SubScreen.EnterPersonalDetails)
    }
    ApplicationColumn(verticalArrangement = Arrangement.spacedBy(0.dp   )) {
        HorizontalPager(pageCount = subScreenList.size, state = pagerState, userScrollEnabled = false) {
            when(subScreenList[it]) {
                SubScreen.SelectTransportation -> {
                    SelectTransportationScreen {
                        scope.launch {
                            pagerState.animateScrollToPage(it + 1)
                        }
                    }

                }
                SubScreen.EnterPersonalDetails -> {
                    EnterPersonalDetailsScreen(
                        scope

                    ) {
                        scope.launch {
                            pagerState.animateScrollToPage(it -1)
                        }
                    }
                }
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun FormOnboardingScreenPreview() {
    FormOnboardingScreen(rememberCoroutineScope())
}
