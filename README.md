# Weather History App - weather_2

## Description
Weather_2 is a comprehensive application designed to fetch and store historical weather data for any given location and date. Utilizing a free weather API, the app provides users with maximum and minimum temperature data which is then stored in a local database for offline access.

## Features

- **Fetch Weather Data**: Input a specific date and location to retrieve historical weather data using a free weather API. The data includes maximum and minimum temperatures.
- **Local Database Storage**: Automatically stores weather data in a local database which allows retrieval of information without the need for an active internet connection.
- **Future Weather Prediction**: For future dates, the app calculates an average temperature based on the data from the last 10 years.
- **Robust User Interface**: A user-friendly interface that ensures easy navigation and interaction with the application.
- **Offline Access**: Access stored weather data offline, with functionalities to query the database for specific dates and view respective weather details.

## Technical Implementation

- **Programming Languages**: Kotlin
- **Database**: ROOM database for local storage
- **API**: Utilizes JSON-based Open-Meteo API for weather data
- **UI Composition**: Jetpack Compose layouts 

## Setup and Installation

1. **Clone the repository**:
   https://github.com/ganeevsingh18/weather_2.git

2. **Open the project in Android Studio**:
- Ensure Android Studio is updated to the latest version.
- Open the project folder as an existing Android Studio project.

3. **Build the project**:
- Use Gradle to build the project and resolve dependencies.

4. **Run the application**:
- Run on a physical device or emulator.

## Usage

1. **Launch the application**:
- Start the app and navigate to the main screen.

2. **Enter Date and Location**:
- Input the required date and location to fetch weather data.

3. **View Weather Data**:
- The app displays maximum and minimum temperatures for the selected date.
- For future dates, view predicted temperatures based on historical averages.

## Contributions

- Contributions are welcome. Please create a pull request with your proposed changes.

## License

- This project is licensed under the MIT License - see the LICENSE.md file for details.


