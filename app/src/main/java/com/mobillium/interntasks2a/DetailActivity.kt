package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherItem =
            intent.getParcelableExtra<WeatherItem>(WeatherConstants.EXTRA_WEATHER_ITEM)

        weatherItem?.let {
            with(binding) {
                textViewTemperature.text = it.temperature
                textViewTemperatureRange.text = it.temperatureRange
                textViewCityName.text = it.cityName
                textViewWeatherDescription.text = it.weatherDescription
            }
        }
    }
}

