package com.mobillium.interntasks2a

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val weatherItem = intent.getParcelableExtra<WeatherItem>("weatherItem")

        if (weatherItem != null) {

            findViewById<TextView>(R.id.textViewTemperature).text = weatherItem.temperature
            findViewById<TextView>(R.id.textViewTemperatureRange).text =
                weatherItem.temperatureRange
            findViewById<TextView>(R.id.textViewCityName).text = weatherItem.cityName
            findViewById<TextView>(R.id.textViewWeatherDescription).text =
                weatherItem.weatherDescription
        }
    }
}