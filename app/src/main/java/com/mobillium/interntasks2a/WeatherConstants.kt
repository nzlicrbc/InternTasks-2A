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

    // Default Weather Data (Consider moving this to a data source or API)
    val DEFAULT_WEATHER_DATA = listOf(
        WeatherItem(temperature = "26°C", temperatureRange = "14°C - 27°C", cityName = "İstanbul", weatherDescription = "Güneşli", weatherCondition = WEATHER_SUNNY, itemId = 0),
        WeatherItem(temperature = "26°C", temperatureRange = "14°C - 27°C", cityName = "Ankara", weatherDescription = "Güneşli", weatherCondition = WEATHER_SUNNY, itemId = 1),
        WeatherItem(temperature = "26°C", temperatureRange = "14°C - 27°C", cityName = "Erzurum", weatherDescription = "Güneşli", weatherCondition = WEATHER_SUNNY, itemId = 2),
        WeatherItem(temperature = "26°C", temperatureRange = "14°C - 27°C", cityName = "Sakarya", weatherDescription = "Güneşli", weatherCondition = WEATHER_SUNNY,itemId = 3)
    )
}