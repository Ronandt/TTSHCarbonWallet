package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationColumn( modifier: Modifier = Modifier,verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically   ), fillEntireScreen: Boolean = true ,content: @Composable () -> Unit) {
    Column(modifier = Modifier.then(if(fillEntireScreen)Modifier.fillMaxSize() else Modifier).padding( 20.dp).then(modifier), horizontalAlignment = Alignment.CenterHorizontally ,verticalArrangement = verticalArrangement) {
        content()
    }
}