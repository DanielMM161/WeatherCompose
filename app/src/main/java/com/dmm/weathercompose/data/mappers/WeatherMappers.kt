package com.dmm.weathercompose.data.mappers

import com.dmm.weathercompose.data.remote.WeatherDataDto
import com.dmm.weathercompose.data.remote.WeatherDto
import com.dmm.weathercompose.domain.weather.WeatherData
import com.dmm.weathercompose.domain.weather.WeatherInfo
import com.dmm.weathercompose.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
	val index: Int,
	val data: WeatherData
)


fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
	return time.mapIndexed { index, time ->
		val temperature = temperature[index]
		val weatherCode = weatherCodes[index]
		val windSpeed = windSpeeds[index]
		val pressure = pressures[index]
		val humidity = humidities[index]
		IndexedWeatherData(
			index = index,
			data = WeatherData(
				time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
				temperatureCelsius = temperature,
				pressure = pressure,
				windSpeed = windSpeed,
				humidity = humidity,
				weatherType = WeatherType.fromWMO(weatherCode)
			)
		)
	}.groupBy {
		it.index / 24
	}.mapValues {
		it.value.map { it.data }
	}
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
	val weahterDataMap = weatherData.toWeatherDataMap()
	val now = LocalDateTime.now()
	val currentWeatherData = weahterDataMap[0]?.find{
		val hour = if(now.minute < 30) now.hour else now.hour + 1
		it.time.hour == hour
	}
	return WeatherInfo(
		weatherDataPerDay = weahterDataMap,
		currentWeatherData = currentWeatherData
	)
}