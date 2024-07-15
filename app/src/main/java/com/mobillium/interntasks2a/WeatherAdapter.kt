package com.mobillium.interntasks2a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.databinding.ItemWeatherBinding

class WeatherAdapter(
    private var weatherData: List<WeatherItem>,
    private val onItemClickListener: (WeatherItem) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    companion object {
        const val WEATHER_SUNNY = "sunny"
        const val WEATHER_CLOUDY = "cloudy"
        const val WEATHER_RAINY = "rainy"
        const val WEATHER_SNOWY = "snowy"
        const val WEATHER_WINDY = "windy"
    }

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
                "sunny" -> R.drawable.ic_sunny
                "cloudy" -> R.drawable.ic_cloudy
                "rainy" -> R.drawable.ic_rainy
                "snowy" -> R.drawable.ic_snowy
                else -> R.drawable.ic_wind
            }
            imageViewWeatherIcon.setImageResource(iconResource)

            root.setOnClickListener {
                onItemClickListener.invoke(currentItem)
            }
        }
    }

    override fun getItemCount(): Int = weatherData.size

    fun updateData(newWeatherItems: List<WeatherItem>) {
        this.weatherData = newWeatherItems
        notifyDataSetChanged()
    }
}
