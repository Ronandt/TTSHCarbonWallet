package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationColumn( verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically   ), content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally ,verticalArrangement = verticalArrangement) {
        content()
    }
}