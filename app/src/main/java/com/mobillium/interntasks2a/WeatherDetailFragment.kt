package com.mobillium.interntasks2a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding
import kotlin.random.Random

class WeatherDetailFragment : Fragment() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private var currentTemperature: String = ""
    private var itemId: Int = -1
    private val args: WeatherDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherItem = args.weatherItem

        if (weatherItem != null) {
            currentTemperature = weatherItem.temperature
            itemId = weatherItem.itemId
            binding.textViewTemperature.text = currentTemperature
            binding.textViewTemperatureRange.text = weatherItem.temperatureRange
            binding.textViewCityName.text = weatherItem.cityName
            binding.textViewWeatherDescription.text = weatherItem.weatherDescription
        }

        binding.imageViewRefreshIcon.setOnClickListener {
            generateRandomTemperature()
        }

        binding.buttonUpdateData.setOnClickListener {
            setFragmentResult(WeatherConstants.REQUEST_KEY, Bundle().apply{
                putString(WeatherConstants.UPDATED_TEMPERATURE_KEY, currentTemperature)
                putInt(WeatherConstants.ITEM_ID_KEY, itemId)
            })
            findNavController().popBackStack()
        }
    }

    private fun generateRandomTemperature() {
        val minTemp = 14
        val maxTemp = 27
        val randomTemperature = Random.nextInt(minTemp, maxTemp + 1)
        currentTemperature = "$randomTemperature°C"
        binding.textViewTemperature.text = currentTemperature
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}