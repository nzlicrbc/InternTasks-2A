package com.mobillium.interntasks2a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobillium.interntasks2a.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherAdapter = WeatherAdapter(getWeatherData()) { weatherItem ->
            val intent = Intent(this@ListActivity, DetailActivity::class.java)
            intent.putExtra("weatherItem", weatherItem)
            startActivity(intent)
        }

        binding.recyclerViewWeather.apply{
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@ListActivity)

        }
    }

    private fun getWeatherData(): List<WeatherItem> {
        return listOf(
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14°C - 27°C",
                cityName = "İstanbul",
                weatherDescription = "Güneşli",
                weatherCondition = "sunny",
                itemId = 0
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14°C - 27°C",
                cityName = "Ankara",
                weatherDescription = "Güneşli",
                weatherCondition = "sunny",
                itemId = 1
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14°C - 27°C",
                cityName = "Erzurum",
                weatherDescription = "Güneşli",
                weatherCondition = "sunny",
                itemId = 2
            ),
            WeatherItem(
                temperature = "26°C",
                temperatureRange = "14°C - 27°C",
                cityName = "Sakarya",
                weatherDescription = "Güneşli",
                weatherCondition = "sunny",
                itemId = 3
            ),
        )
    }
}

