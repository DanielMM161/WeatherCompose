package com.dmm.weathercompose.domain.weather

data class WeatherInfo(
	val weatherDataPerDay: Map<Int, List<WeatherData>>,
	val currentWeatherData: WeatherData?
)
