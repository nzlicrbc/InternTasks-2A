package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val weatherData = listOf(
            WeatherItem("26°C", "14°C - 27°C", "İstanbul", "Güneşli", "sunny"),
            WeatherItem("26°C", "14°C - 27°C", "Ankara", "Güneşli", "sunny"),
            WeatherItem("26°C", "14°C - 27°C", "Erzurum", "Güneşli", "sunny"),
            WeatherItem("26°C", "14°C - 27°C", "Sakarya", "Güneşli", "sunny"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewWeather)
        recyclerView.adapter = WeatherAdapter(weatherData, this) { weatherItem ->
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}