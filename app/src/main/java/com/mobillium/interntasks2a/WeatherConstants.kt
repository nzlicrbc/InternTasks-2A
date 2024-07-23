package com.mobillium.interntasks2a

object WeatherConstants {

    // Weather Conditions
    const val WEATHER_SUNNY = "sunny"
    const val WEATHER_CLOUDY = "cloudy"
    const val WEATHER_RAINY = "rainy"
    const val WEATHER_SNOWY = "snowy"
    const val WEATHER_WINDY = "windy"

    // Intent Extra Keys
    const val EXTRA_WEATHER_ITEM = "weatherItem"

    // Fragment Result Keys
    const val REQUEST_KEY = "requestKey"
    const val UPDATED_TEMPERATURE_KEY = "updatedTemperature"
    const val ITEM_ID_KEY = "itemId"

    // Default Weather Data
    val DEFAULT_WEATHER_DATA: List<WeatherItem> = WeatherDataUtil.createDefaultWeatherData()
}