package com.dmm.weathercompose.domain.repository

import com.dmm.weathercompose.domain.util.Resource
import com.dmm.weathercompose.domain.weather.WeatherInfo

interface WeatherRepository {
	suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}