package com.mobillium.interntasks2a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeatherListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter
    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeather)
        weatherAdapter = WeatherAdapter(
            viewModel.weatherItems.value ?: emptyList(),
            requireContext()
        ) { weatherItem ->
            val action =
                WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment(
                    weatherItem
                )
            findNavController().navigate(action)
        }

        recyclerView.adapter = weatherAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherItems.observe(viewLifecycleOwner) { updatedWeatherItems ->
            if (updatedWeatherItems != null) {
                weatherAdapter.updateData(updatedWeatherItems)
            }
        }

        if (viewModel.weatherItems.value.isNullOrEmpty()) {
            viewModel.weatherItems.value = getWeatherData()
        }
    }


    private fun getWeatherData(): List<WeatherItem> {
        var itemIdCounter = 0
        return listOf(
            WeatherItem("26°C", "14°C - 27°C", "İstanbul", "Güneşli", "sunny", itemIdCounter++),
            WeatherItem("26°C", "14°C - 27°C", "Ankara", "Güneşli", "sunny", itemIdCounter++),
            WeatherItem("26°C", "14°C - 27°C", "Erzurum", "Güneşli", "sunny", itemIdCounter++),
            WeatherItem("26°C", "14°C - 27°C", "Sakarya", "Güneşli", "sunny", itemIdCounter++),
        )
    }
}