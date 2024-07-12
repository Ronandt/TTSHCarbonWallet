package com.ttsh.carbonwallet.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.theme.Primary

@Composable
fun HomeScreen() {
    val localConfiguration = LocalConfiguration.current
    LaunchedEffect(key1 = Unit) {
        
    }
Column {
    Box(modifier = Modifier
        ) {

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(localConfiguration.screenWidthDp.dp)
                .offset(y = -localConfiguration.screenWidthDp.dp / 2)
                .background(Primary, shape = CircleShape))

        ApplicationColumn(verticalArrangement = Arrangement.spacedBy(0.dp   )) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp   )){
                    Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "Profile picture", modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        ), contentScale = ContentScale.Crop, )
                    Text(text = "Jane Doe", color = Color.White)
                }
                Row {
                    Text(text = "Master Rank", color = Color.White)
                    Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "Profile picture", modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        ), contentScale = ContentScale.Crop, )

                }
            }
            Text(text = "Let's start", color = Color.White, fontSize = 34.sp)
            Text(text = "Start saving carbon today!", color =  Color.White)
        }


    }
}
}