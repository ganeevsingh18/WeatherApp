package com.example.weather2
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.*
import android.content.Context
import android.content.DialogInterface
import android.app.DatePickerDialog



class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val _weatherState = MutableStateFlow("")
    val weatherState = _weatherState.asStateFlow()

    private var selectedDate: String = ""

    fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, { _, year, month, dayOfMonth ->
            val selectedDate = String.format(Locale.US, "%d-%02d-%02d", year, month + 1, dayOfMonth)
            onDateSelected(selectedDate)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun getWeather(latitude: String, longitude: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://api.open-meteo.com/v1/forecast?hourly=temperature_2m&latitude=$latitude&longitude=$longitude")
                    .build()

                val response = client.newCall(request).execute()
                val responseBody = response.body?.string() ?: ""

                // Parse the weather data on a background thread
                val weatherData = parseWeatherData(responseBody, date)

                // Update UI on the main thread
                withContext(Dispatchers.Main) {
                    _weatherState.value = weatherData
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _weatherState.value = "Error retrieving weather data: ${e.message}"
                }
            }
        }
    }

    private fun parseWeatherData(response: String, date: String): String {
        val json = JSONObject(response)
        val times = json.getJSONObject("hourly").getJSONArray("time")
        val temperatures = json.getJSONObject("hourly").getJSONArray("temperature_2m")

        val dayTemperatures = mutableListOf<Double>()
        var foundDataForDate = false

        for (i in 0 until times.length()) {
            val time = times.getString(i)
            if (time.startsWith(date)) {
                val temperature = temperatures.getDouble(i)
                dayTemperatures.add(temperature)
                foundDataForDate = true
            }
        }

        return if (foundDataForDate) {
            val minTemp = dayTemperatures.minOrNull() ?: 0.0
            val maxTemp = dayTemperatures.maxOrNull() ?: 0.0
            "Date: $date - Min: $minTemp°C, Max: $maxTemp°C"
        } else {
            val averageTemp = if (temperatures.length() > 0) {
                val totalTemp = temperatures.run {
                    var sum = 0.0
                    for (i in 0 until length()) sum += getDouble(i)
                    sum
                }
                totalTemp / temperatures.length()
            } else {
                0.0
            }
            "No data for this date. Average temperature: ${"%.2f".format(averageTemp)}°C"
        }
    }
}
