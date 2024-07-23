package com.mobillium.interntasks2a

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherItem(
    var temperature: String,
    val temperatureRange: String,
    val cityName: String,
    val weatherDescription: String,
    val weatherCondition: String,
    val itemId: Int = -1,
) : Parcelable