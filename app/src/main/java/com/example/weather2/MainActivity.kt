package com.example.weather2
import androidx.compose.ui.platform.LocalContext
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import java.util.*

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext

import kotlinx.coroutines.launch
import android.widget.Toast



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WeatherApp()
            }
        }
    }
}

@Composable
fun WeatherApp(viewModel: WeatherViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    val weatherState = viewModel.weatherState.collectAsState()
    val context = LocalContext.current

    Column {
        OutlinedTextField(
            value = latitude,
            onValueChange = { latitude = it },
            label = { Text("Latitude") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = longitude,
            onValueChange = { longitude = it },
            label = { Text("Longitude") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                viewModel.showDatePicker(context) { selectedDate ->
                    date = selectedDate // Receive the selected date from the ViewModel and assign it
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date")
        }
        Button(
            onClick = {
                if (date.isNotEmpty() && latitude.isNotEmpty() && longitude.isNotEmpty()) {
                    scope.launch {
                        viewModel.getWeather(latitude, longitude, date)
                    }
                } else {
                    Toast.makeText(context, "Please select a date and enter latitude and longitude.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Weather")
        }
        Text(text = weatherState.value)
    }
}

