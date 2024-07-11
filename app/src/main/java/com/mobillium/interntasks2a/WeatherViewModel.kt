package com.mobillium.interntasks2a


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    private val _weatherItems = MutableLiveData<List<WeatherItem>?>(emptyList())
    val weatherItems: MutableLiveData<List<WeatherItem>?> = _weatherItems

    fun updateTemperature(itemId: Int, newTemperature: String) {
        val updatedList = _weatherItems.value?.map {
            if (it.itemId == itemId) {
                it.copy(temperature = newTemperature)
            } else {
                it
            }
        }
        _weatherItems.value = updatedList
    }
}