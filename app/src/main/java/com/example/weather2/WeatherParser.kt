package com.example.weather2
import org.json.JSONObject

class WeatherParser {
    fun parse(response: String): WeatherResponse {
        val json = JSONObject(response)
        val times = json.getJSONArray("time")
        val temperatures = json.getJSONArray("temperature_2m")
        val hourlyDataList = mutableListOf<HourlyData>()
        for (i in 0 until times.length()) {
            val time = times.getString(i)
            val temperature = temperatures.getDouble(i)
            hourlyDataList.add(HourlyData(time, temperature))
        }
        return WeatherResponse(hourlyDataList)
    }
}
