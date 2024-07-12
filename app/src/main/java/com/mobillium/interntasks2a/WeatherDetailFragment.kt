package com.mobillium.interntasks2a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlin.random.Random

class WeatherDetailFragment : Fragment() {

    private lateinit var temperatureTextView: TextView
    private lateinit var cityNameTextView: TextView
    private var currentTemperature: String = ""
    private var itemId: Int = -1
    private val args: WeatherDetailFragmentArgs by navArgs()
    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_detail, container, false)

        temperatureTextView = view.findViewById(R.id.textViewTemperature)
        val refreshIcon = view.findViewById<ImageView>(R.id.imageViewRefreshIcon)
        val updateButton = view.findViewById<Button>(R.id.buttonUpdateData)
        cityNameTextView = view.findViewById(R.id.textViewCityName)

        val weatherItem = args.weatherItem

        if (weatherItem != null) {
            currentTemperature = weatherItem.temperature
            itemId = weatherItem.itemId
            temperatureTextView.text = currentTemperature
            cityNameTextView.text = weatherItem.cityName
        }

        refreshIcon.setOnClickListener {
            generateRandomTemperature()

            viewModel.updateTemperature(itemId, currentTemperature)
        }

        updateButton.setOnClickListener {
            viewModel.updateTemperature(itemId, currentTemperature)
            findNavController().popBackStack()
        }

        return view
    }

    private fun generateRandomTemperature() {
        val minTemp = 14
        val maxTemp = 27
        val randomTemperature = Random.nextInt(minTemp, maxTemp + 1)
        currentTemperature = "$randomTemperature°C"
        temperatureTextView.text = currentTemperature
    }
}