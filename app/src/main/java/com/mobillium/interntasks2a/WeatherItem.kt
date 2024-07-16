package com.mobillium.interntasks2a

import android.os.Parcel
import android.os.Parcelable

data class WeatherItem(
    val temperature: String,
    val temperatureRange: String,
    val cityName: String,
    val weatherDescription: String,
    val weatherCondition: String,
    val itemId: Int = -1
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(temperature)
        parcel.writeString(temperatureRange)
        parcel.writeString(cityName)
        parcel.writeString(weatherDescription)
        parcel.writeString(weatherCondition)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherItem> {
        override fun createFromParcel(parcel: Parcel): WeatherItem {
            return WeatherItem(parcel)
        }

        override fun newArray(size: Int): Array<WeatherItem?> {
            return arrayOfNulls(size)
        }
    }
}