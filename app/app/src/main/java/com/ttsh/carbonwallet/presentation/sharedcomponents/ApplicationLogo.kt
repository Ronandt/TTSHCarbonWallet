package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ttsh.carbonwallet.R

@Composable
fun ApplicationLogo(size: Dp = 120.dp   , modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.carbonwallet_logo), contentDescription = "Logo",
        modifier =Modifier.size(size).then(modifier),  contentScale = ContentScale.Crop)
}