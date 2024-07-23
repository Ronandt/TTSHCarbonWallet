package com.ttsh.carbonwallet.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.screens.homescreen.components.TPieChart
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationColumn
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.PrimaryGreen

@Composable
fun HomeScreen() {
    val localConfiguration = LocalConfiguration.current



Column {

    Box(modifier = Modifier
        ) {

            Spacer(modifier = Modifier
                .requiredWidth(localConfiguration.screenWidthDp.dp * 1.2f)
                .height(localConfiguration.screenWidthDp.dp * 1.2f)
                .offset(y = -localConfiguration.screenWidthDp.dp / 1.5f)
                .background(Primary, shape = CircleShape))

        ApplicationColumn(verticalArrangement = Arrangement.spacedBy(8.dp   ), fillEntireScreen = false) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp   ), verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "Profile picture", modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        ), contentScale = ContentScale.Crop, )
                    Text(text = "Jane Doe", color = Color.White)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp   ), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Master Rank", color = Color.White)
                    Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "Profile picture", modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        ), contentScale = ContentScale.Crop, )

                }
            }
            Text(text = "Let's start", color = Color.White, fontSize = 40.sp)
            Text(text = "Start saving carbon today!", color =  Color.White, fontSize = 22.sp    )
            Spacer(modifier = Modifier.height(40.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp   ), modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(vertical = 18.dp)) {
                Column {
                    Text(text = "200Kg", color = PrimaryGreen)
                    Text(text = "Total Saved")
                }
                Spacer(modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(Color.Black))
                Column {
                    Text(text = "10000 Points", color =  PrimaryGreen)
                    Text(text = "Accumulated ")
                }

            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp), horizontalArrangement = Arrangement.Start,) {
                Text(text = "Your Impact", fontSize = 20.sp )

            }
            Card(modifier = Modifier) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp )) {
                    TPieChart()
                    Text(text = "Food")
                    Text(text = "Materials")
                    Text(text = "Transport")
                }

            }
                  


        }
        }
      
   


}
}