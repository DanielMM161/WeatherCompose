package com.dmm.weathercompose.data.repository

import com.dmm.weathercompose.data.mappers.toWeatherInfo
import com.dmm.weathercompose.data.remote.WeatherApi
import com.dmm.weathercompose.domain.repository.WeatherRepository
import com.dmm.weathercompose.domain.util.Resource
import com.dmm.weathercompose.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
	private val api: WeatherApi
) : WeatherRepository {

	override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
		return try {
			Resource.Success(
				data = api.getWeatherData(
					lat = lat,
					long = long
				).toWeatherInfo()
			)
		}catch (e: Exception) {
			e.printStackTrace()
			Resource.Error(e.message ?: "An unknown error ocurred")
		}
	}

}