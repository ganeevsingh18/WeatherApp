package com.example.weather2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data")
data class WeatherData(
    @PrimaryKey val date: String,
    val maxTemperature: Double,
    val minTemperature: Double
)