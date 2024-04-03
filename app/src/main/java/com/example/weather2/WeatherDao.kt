package com.example.weather2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(weatherData: WeatherData)

    @Query("SELECT * FROM weather_data WHERE date = :date")
    suspend fun getWeatherDataByDate(date: String): WeatherData?
}