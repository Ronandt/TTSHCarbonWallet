package com.ttsh.carbonwallet.presentation.screens.formonboardingscreen

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationDescription
import kotlinx.coroutines.selects.select

@Composable
fun FormOnboardingScreen(){
    val selection = remember {listOf("Train", "Bus", "Bicycle", "Walk")}
    ApplicationColumn(verticalArrangement = Arrangement.spacedBy(10.dp  )) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Exit", modifier = Modifier.size(35.dp))
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(bottom = 10.dp )) {
            Text(text = "Select Transportation", fontWeight = FontWeight.Bold, fontSize = 20.sp )
            ApplicationDescription(
                text = "Select the mode of transportation that you take everyday",
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            selection.forEach {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

                        Text(text = it, fontSize = 18.sp     )
                        AsyncImage(model = R.drawable.double_decker, contentDescription ="Transportation Mode: $it", modifier = Modifier
                            .size(50.dp)
                            .clip(
                                CircleShape
                            ), contentScale = ContentScale.Crop, )
                    }
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp), horizontalArrangement = Arrangement.Center) {
            Text(text = "You have selected bus", fontWeight = FontWeight.SemiBold)
            
        }
        
        ApplicationButton(text = "Continue", onClick = { /*TODO*/ })

        
        
    }
}