package com.mobillium.interntasks2a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobillium.interntasks2a.databinding.ActivityListBinding

class WeatherListFragment : Fragment() {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherAdapter: WeatherAdapter
    private var weatherData: MutableList<WeatherItem> = mutableListOf()

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherData.addAll(WeatherConstants.DEFAULT_WEATHER_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherAdapter = WeatherAdapter(weatherData) { weatherItem ->
            val action = WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment(weatherItem)
            findNavController().navigate(action)
        }

        binding.recyclerViewWeather.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        setFragmentResultListener(WeatherConstants.REQUEST_KEY) { _, bundle ->
            val updatedTemperature = bundle.getString(WeatherConstants.UPDATED_TEMPERATURE_KEY)
            val itemId = bundle.getInt(WeatherConstants.ITEM_ID_KEY)
            val indexToUpdate = weatherData.indexOfFirst { weatherItem -> weatherItem.itemId == itemId }
            if (indexToUpdate != -1 && updatedTemperature != null) {
                weatherData[indexToUpdate] =
                    weatherData[indexToUpdate].copy(temperature = updatedTemperature)
                weatherAdapter.notifyItemChanged(indexToUpdate)
            }
        }
    }
}