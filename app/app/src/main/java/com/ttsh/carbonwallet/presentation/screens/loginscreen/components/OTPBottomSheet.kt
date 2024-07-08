package com.ttsh.carbonwallet.presentation.screens.loginscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ttsh.carbonwallet.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OTPBottomSheet(
    content: @Composable () -> Unit,
    scope: CoroutineScope
) {
    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
    ModalBottomSheetLayout(sheetContent = {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(8.dp)) {
            Box(modifier = Modifier.fillMaxWidth()){
                Text(text = "Enter OTP", fontWeight = FontWeight.SemiBold, modifier = Modifier.align(Alignment.Center))
                IconButton(onClick = {
                    scope.launch {
                        modalBottomSheetState.hide()
                    }
                   }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp,Alignment.CenterHorizontally)) {

            }
        }
    }) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun OTPBottomSheetPreview() {
    OTPBottomSheet(content = { /*TODO*/ }, scope = rememberCoroutineScope())
}