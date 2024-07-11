package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttsh.carbonwallet.presentation.theme.DescriptionGray

@Composable
fun ApplicationDescription(text: String, textAlign: TextAlign = TextAlign.Left, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = textAlign, modifier = modifier, lineHeight =20.sp  , color =  DescriptionGray, fontSize = 16.sp  )
}