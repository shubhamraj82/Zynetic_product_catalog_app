=> Zynetic Coding Assessment

This is a Kotlin-based Android application that demonstrates the use of modern Android development practices, including Jetpack Compose, Hilt for dependency injection, and Retrofit for API communication.

==>  Project Overview

The application fetches and displays a list of products from a remote API. Users can view product details, including images, descriptions, and ratings. The app is built with a clean architecture approach, ensuring scalability and maintainability.

==> Setup Instructions

Follow these steps to set up and run the project:

1. **Clone the Repository**  
   Clone the repository to your local machine:
   ```bash
   git clone <repository-link>

   ==> the apk file is provided google drive link :-


 ==> Open in Android Studio  
 
-> Open the project in Android Studio (version Android Studio Meerkat | 2024.3.1 or later).
-> Let Gradle sync the dependencies.

-> API Configuration  
   The app uses a placeholder API endpoint. Update the BASE_URL in the Retrofit configuration if needed.
Run the App  
-> Connect an Android device or start an emulator.
Click the "Run" button in Android Studio to build and launch the app.
 
API: The app assumes the API provides endpoints for fetching products and product details. The API responses are modeled in Product and ProductResponse data classes.
Hilt: Dependency injection is configured using Hilt. Ensure the @HiltAndroidApp annotation is applied to the application class.
Navigation: Jetpack Compose Navigation is used for seamless navigation between screens.
Error Handling: Basic error handling is implemented for API calls.
