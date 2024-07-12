package com.ttsh.carbonwallet.presentation.screens.formonboardingscreen.subscreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ttsh.carbonwallet.R
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationButton
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationDescription
import com.ttsh.carbonwallet.presentation.sharedcomponents.ApplicationTextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterPersonalDetailsScreen( scope: CoroutineScope,onBack: () -> Unit) {
    var animationTrigger by remember {mutableStateOf(false)}
    LaunchedEffect(Unit) {
        delay(450)
        animationTrigger= true
    }
    AnimatedVisibility(visible = animationTrigger, enter = fadeIn(), exit = fadeOut()) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Enter Personal Details", fontWeight = FontWeight.Bold, fontSize = 20.sp )
                IconButton(onClick = {
                    scope.launch {
                        animationTrigger = false
                        delay(300)
                        onBack()
                    }

                }

                 ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back")
                }

            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(bottom = 30.dp )) {

                ApplicationDescription(
                    text = "Enter your address and name for your profile", modifier = Modifier
                )
            }


            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ApplicationTextField(value = "", onValueChange = {}, title = "Preferred Username" )
                ApplicationTextField(value = "", onValueChange = {}, title = "Department" )
                ApplicationTextField(value = "", onValueChange = {}, title = "Address" , supportingText = "Address will not be stored")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp), horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally  ), verticalAlignment = Alignment.CenterVertically) {




            }

            ApplicationButton(text = "Finish", onClick = {}, modifier = Modifier.padding(top = 10.dp    ), enabled = true)
        }

    }

}


@Composable
@Preview(showBackground = true)
fun EnterPersonalDetailsPreview() {
    EnterPersonalDetailsScreen(scope = rememberCoroutineScope(), onBack = {})
}