package com.dmm.weathercompose.presentation

import com.dmm.weathercompose.domain.weather.WeatherInfo

data class WeatherState(
	val weatherInfo: WeatherInfo? = null,
	val isLoading: Boolean = false,
	val error:String? = null
)
