## Project Overview

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Jetpack Compose Navigation

## Features

The app offers a complete check-in flow for passengers:

1. **Online Check-in** - Initial screen where passengers can start their check-in process
2. **Passenger Details** - Screen for entering or confirming passenger information
3. **Check-in Confirmation** - Confirmation screen after successful check-in
4. **Boarding Pass** - Digital boarding pass with barcode generation

## Tech Stack

- **Jetpack Compose** - Modern toolkit for building native Android UI
- **Compose Navigation** - For handling navigation between screens
- **LiveData** - For observing data changes
- **Barcode Generation** - Using Composed Barcodes library
- **Material Design** - For consistent and modern UI components

## Development Environment

- **Compile SDK**: 35
- **Target SDK**: 34
- **Min SDK**: 24
- **Kotlin Version**: Uses JVM target 11
- **Gradle**: Kotlin DSL build scripts

## Project Structure

The project follows a structured organization:

- **components/** - Reusable UI components
- **data/** - Data handling and repositories
- **model/** - Data models and entities
- **navigation/** - Navigation routes and configuration
- **screens/** - UI screens implementation
- **viewmodel/** - ViewModels for each screen

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11 or higher

### Building the Project

1. Clone the repository
2. Open the project in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device

## Acknowledgments

- This project was created as a code test for BookCabin
