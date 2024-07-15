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

        val weatherItem = intent.getParcelableExtra<WeatherItem>("weatherItem")

        if (weatherItem != null) {
            binding.textViewTemperature.text = weatherItem.temperature
            binding.textViewTemperatureRange.text = weatherItem.temperatureRange
            binding.textViewCityName.text = weatherItem.cityName
            binding.textViewWeatherDescription.text = weatherItem.weatherDescription
        }
    }
}
