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

        weatherAdapter = WeatherAdapter(WeatherConstants.DEFAULT_WEATHER_DATA) { weatherItem ->
            val intent = Intent(this@ListActivity, DetailActivity::class.java)
            intent.putExtra(WeatherConstants.EXTRA_WEATHER_ITEM, weatherItem)
            startActivity(intent)
        }

        binding.recyclerViewWeather.adapter = weatherAdapter
    }
}

