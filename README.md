# NIT3213 Final Assignment - Android Application

This project is an Android application developed as part of the NIT3213 Final Assignment. The app demonstrates proficiency in API integration, user interface design, and Android development best practices.

## Features
- **User Authentication:** Users can log in using the provided API. The app verifies user credentials and retrieves a `keypass` for further requests.
- **Dashboard Display:** After successful login, the app displays a list of plants, fetched from the API using the `keypass`. Each item displays the plant's scientific name, common name, care level, and light requirement.
- **Details Screen:** On selecting an item from the Dashboard, the app displays detailed information about the selected plant, including a description.

## Prerequisites

- Android Studio (version 4.1 or higher)
- Android SDK (API Level 21 or higher)
- Java 8 or Kotlin enabled

## Project Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/elizatlai/assessment2.git

2. Open the project in Android Studio.
3. Sync the project by selecting File > Sync Project with Gradle Files.
4. Ensure that all necessary dependencies are installed. Android Studio will automatically download them based on the build.gradle file.

## API Details

This app interacts with the vu-nit3213-api for user authentication and data retrieval.

### Login:
- URL: https://vu-nit3213-api.onrender.com/ort/auth
- Method: POST
- Request Body:
{
  "username": "Eliza",
  "password": "s4578856"
}
- Response: Returns a keypass to use in further requests, such as retrieving plant data.

### Dashboard

- URL: https://vu-nit3213-api.onrender.com/dashboard/{keypass}
- Method: GET
- Response: Provides a list of plant entities with properties such as scientific name, common name, care level, light requirements, and descriptions.

## Running the Application

1. Open Android Studio and ensure the project is fully loaded.

2. Connect an Android device or start an emulator.
  
3. Build the app by selecting Build > Rebuild Project.

4. After the build is successful, click the Run button
   
5. Use Eliza as the username and s4578856 as the password to log in.

## Dependency Injection

This project uses Hilt for dependency injection. All necessary dependencies are injected into ViewModels and Repository classes.

## Unit Testing

Unit tests have been implemented for critical components such as the LoginViewModel. To run the unit tests:

1. Open the Project pane in Android Studio.
  
2. Right-click on the test or androidTest folder.

3. Select Run Tests to execute the tests and view the results.


