package com.ttsh.carbonwallet.presentation.sharedcomponents

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import com.ttsh.carbonwallet.presentation.theme.Primary

@Composable
fun ApplicationCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(checked = checked, onCheckedChange = onCheckedChange, colors = CheckboxDefaults.colors(
        checkedColor = Primary
    ))
}