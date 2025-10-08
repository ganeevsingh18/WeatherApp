# WeatherApp

## Description
WeatherApp is an Android application that retrieves and stores **historical weather data** for any location and date using the free **Open-Meteo API**. The app saves maximum and minimum temperature data in a local **ROOM database**, ensuring offline access. For future dates, it applies an **ARIMA model** trained on the past 10 years of data to predict temperatures.

## Features
- Historical Weather Retrieval: Fetch max/min temperatures for any location and date via Open-Meteo API.  
- Future Prediction: ARIMA-based forecasting for upcoming dates.  
- Local Database: Stores weather records in ROOM for offline access.  
- Offline Access: Query and view stored data without internet.  
- Modern UI: Built with Jetpack Compose for a clean and intuitive interface.  

## Tech Stack
- Language: Kotlin  
- Database: ROOM (SQLite)  
- API: Open-Meteo (JSON)  
- UI: Jetpack Compose  

## Setup
1. Clone the repository:
   git clone https://github.com/ganeevsingh18/WeatherApp.git
2. Open the project in Android Studio (latest version).  
3. Build with Gradle and resolve dependencies.  
4. Run on an emulator or physical device.  

## Usage
1. Launch the app.  
2. Enter a date and location.  
3. View historical data (max/min temperatures).  
4. For future dates, view predicted values based on historical data.  

## Contributions
Contributions are welcome via pull requests.  

## License
This project is licensed under the MIT License – see the [LICENSE.md](LICENSE.md) file for details.
