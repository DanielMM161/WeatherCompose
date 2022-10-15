package com.dmm.weathercompose.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable

@Composable
fun WeatherComposeTheme(
	content: @Composable () -> Unit
) {
	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}