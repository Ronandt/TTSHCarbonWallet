package com.ttsh.carbonwallet.presentation.screens.formonboardingscreen

import androidx.compose.animation.animateColorAsState
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
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationDescription
import kotlinx.coroutines.selects.select

enum class TransportationMode {
    Train,
    Bus,
    Bicycle,
    Walk,
    None
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormOnboardingScreen(){
    val transportationModeChoices = remember {listOf(TransportationMode.Train, TransportationMode.Bus, TransportationMode.Bicycle, TransportationMode.Walk)}
    var selectedTransportationMode by remember {mutableStateOf<TransportationMode>(TransportationMode.None)}

    ApplicationColumn(verticalArrangement = Arrangement.spacedBy(0.dp   )) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Select Transportation", fontWeight = FontWeight.Bold, fontSize = 20.sp )
            IconButton(onClick = { }, ) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Exit", modifier = Modifier.size(26.dp))
            }

        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(bottom = 30.dp )) {

            ApplicationDescription(
                text = "Select the mode of transportation that you take everyday", modifier = Modifier
            )
        }


        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            transportationModeChoices.forEach {
                val cardColour by animateColorAsState(targetValue =if(selectedTransportationMode == it)  Color(0x699D160D) else MaterialTheme.colorScheme.surfaceVariant )
                Card(modifier = Modifier.fillMaxWidth(), onClick = {
                    selectedTransportationMode = it
                }, colors = CardDefaults.cardColors(containerColor =cardColour)) {
                    Row(modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

                        Text(text = it.name, fontSize = 18.sp     )
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
            .padding(vertical = 16.dp), horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally  )) {
            if(selectedTransportationMode!= TransportationMode.None) {
                Icon(Icons.Default.Info, contentDescription = "Info" )
                Text(text = "You have selected ${selectedTransportationMode.name}", fontWeight = FontWeight.SemiBold)
            }

            
        }
        
        ApplicationButton(text = "Continue", onClick = { }, modifier = Modifier.padding(top = 10.dp    ), enabled = selectedTransportationMode != TransportationMode.None)

        
        
    }
}

@Preview(showBackground = true)
@Composable
fun FormOnboardingScreenPreview() {
    FormOnboardingScreen()
}
