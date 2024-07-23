package com.mobillium.interntasks2a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.WeatherConstants.WEATHER_CLOUDY
import com.mobillium.interntasks2a.WeatherConstants.WEATHER_RAINY
import com.mobillium.interntasks2a.WeatherConstants.WEATHER_SNOWY
import com.mobillium.interntasks2a.WeatherConstants.WEATHER_SUNNY
import com.mobillium.interntasks2a.databinding.ItemWeatherBinding

class WeatherAdapter(
    private var weatherData: List<WeatherItem>,
    private val onItemClickListener: (WeatherItem) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = weatherData[position]
        with(holder.binding) {
            textViewTemperature.text = currentItem.temperature
            textViewTemperatureRange.text = currentItem.temperatureRange
            textViewCityName.text = currentItem.cityName
            textViewWeatherDescription.text = currentItem.weatherDescription

            val iconResource = when (currentItem.weatherCondition) {
                WEATHER_SUNNY -> R.drawable.ic_sunny
                WEATHER_CLOUDY -> R.drawable.ic_cloudy
                WEATHER_RAINY -> R.drawable.ic_rainy
                WEATHER_SNOWY -> R.drawable.ic_snowy
                else -> R.drawable.ic_wind
            }

            imageViewWeatherIcon.setImageResource(iconResource)

            root.setOnClickListener {
                onItemClickListener.invoke(currentItem)
            }
        }
    }

    override fun getItemCount(): Int = weatherData.size
}
