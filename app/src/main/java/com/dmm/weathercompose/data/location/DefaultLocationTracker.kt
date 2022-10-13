package com.dmm.weathercompose.data.location

import android.app.Application
import android.location.Location
import com.dmm.weathercompose.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject

class DefaultLocationTracker @Inject constructor(
	private val locationClient: FusedLocationProviderClient,
	private val application: Application
) : LocationTracker {

	override suspend fun getCurrentLocation(): Location? {
		TODO("Not yet implemented")
	}
}