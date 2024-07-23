package com.mobillium.interntasks2a

import com.mobillium.interntasks2a.WeatherConstants.WEATHER_SUNNY

object WeatherDataUtil {
    fun createDefaultWeatherData(): List<WeatherItem> {
        return listOf(
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14° - 27°",
                cityName = "İstanbul",
                weatherDescription = "Güneşli",
                weatherCondition = WEATHER_SUNNY,
                itemId = 0
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14° - 27°",
                cityName = "Ankara",
                weatherDescription = "Güneşli",
                weatherCondition = WEATHER_SUNNY,
                itemId = 1
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14° - 27°",
                cityName = "Erzurum",
                weatherDescription = "Güneşli",
                weatherCondition = WEATHER_SUNNY,
                itemId = 2
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14° - 27°",
                cityName = "Sakarya",
                weatherDescription = "Güneşli",
                weatherCondition = WEATHER_SUNNY,
                itemId = 3
            )
        )
    }
}
