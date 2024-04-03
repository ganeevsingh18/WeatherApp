package com.example.weather2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherData::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
