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

- **Programming Languages**: Kotlin/Java
- **Database**: SQLite for local storage
- **API**: Utilizes JSON-based REST API for weather data
- **UI Composition**: XML layouts with appropriate ID linking for dynamic updates

## Setup and Installation

1. **Clone the repository**:
