import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.R
import com.mobillium.interntasks2a.WeatherItem

class WeatherAdapter(
    private var weatherData: List<WeatherItem>,
    private val context: Context,
    private val onItemClickListener: (WeatherItem) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val temperatureTextView: TextView = itemView.findViewById(R.id.textViewTemperature)
        val temperatureRangeTextView: TextView =
            itemView.findViewById(R.id.textViewTemperatureRange)
        val cityNameTextView: TextView = itemView.findViewById(R.id.textViewCityName)
        val weatherDescriptionTextView: TextView =
            itemView.findViewById(R.id.textViewWeatherDescription)
        val weatherIconImageView: ImageView = itemView.findViewById(R.id.imageViewWeatherIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = weatherData[position]

        holder.temperatureTextView.text = currentItem.temperature
        holder.temperatureRangeTextView.text = currentItem.temperatureRange
        holder.cityNameTextView.text = currentItem.cityName
        holder.weatherDescriptionTextView.text = currentItem.weatherDescription

        val iconResource = when (currentItem.weatherCondition) {
            "sunny" -> R.drawable.ic_sunny
            "cloudy" -> R.drawable.ic_cloudy
            "rainy" -> R.drawable.ic_rainy
            "snowy" -> R.drawable.ic_snowy
            else -> R.drawable.ic_wind
        }
        holder.weatherIconImageView.setImageResource(iconResource)

        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(weatherData[position])
        }
    }

    override fun getItemCount(): Int = weatherData.size

    fun updateData(newWeatherItems: List<WeatherItem>) {
        this.weatherData = newWeatherItems
        notifyDataSetChanged()
    }
}