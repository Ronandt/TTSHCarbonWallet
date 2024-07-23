package com.ttsh.carbonwallet.presentation.screens.homescreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.ttsh.carbonwallet.presentation.theme.ChartDarkBlue
import com.ttsh.carbonwallet.presentation.theme.Primary
import com.ttsh.carbonwallet.presentation.theme.PrimaryGreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TPieChart() {
    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("HP", 30f, ChartDarkBlue),
            PieChartData.Slice("Dell", 30f, PrimaryGreen),
            PieChartData.Slice("Lenovo", 40f,  Primary),

        ), plotType = PlotType.Pie
    )
    val pieChartConfig = PieChartConfig(

        isAnimationEnable = true,
        showSliceLabels = false,
        labelColor = Color.Black,
        labelVisible = true,
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
        animationDuration = 1500
    )
    PieChart(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        pieChartData,
        pieChartConfig
    )
}

@Composable
@Preview(showBackground = true)
fun PieChartPreview() {
   TPieChart()
}