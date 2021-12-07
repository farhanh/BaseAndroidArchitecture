# BaseAndroidArchitecture
The purpose of this base architectural project is to load it with all the latest components and libraries, So it becomes a reference for all kinds of Android projects

## Android Project Guidelines

## 1. Overview:

This document will help us in developing an android app using the best approach towards setting up the configuration, design pattern and technologies in the upcoming projects.

## 2. Project Configuration:

Project should be configured to these settings following the recommendations from Google and market requirements:

* Language: Kotlin
* minSdkVersion: 19
* targetSdkVersion: 30
* Kotlin Style Guidelines

## 3. Technologies:

This section describes all the libraries/frameworks to be used.

### 3.1 Core Libraries

Android Jetpack Libraries will be used for a cleaner and efficient approach in laying down the foundation.

### 3.2 Architecture

This section intends to provide some guidance and foundation for the app’s architecture where the main goal is to produce SOLID, clean and testable code following two common architectural principles:

* Separation of concerns
* Drive UI from a model

It's impossible to have one way of writing apps that works best for every scenario. That being said, this recommended architecture is a good starting point for most situations and workflows.

### 3.2.1 MVVM with Clean Architecture

MVVM separates your view (i.e. Activities and Fragments) from your business logic. MVVM is enough for small projects, but when your codebase becomes huge, your ViewModels start bloating. Separating responsibilities becomes hard.

MVVM with Clean Architecture is pretty good in such cases. It goes one step further in separating the responsibilities of your code base. It clearly abstracts the logic of the actions that can be performed in your app.

Here business logic is completely decoupled from the UI. It makes the code very easy to maintain and test. This design pattern is based on the following three android architectural components:

* View Model
* Live Data
* Room

### 3.2.1.1 MVI Pattern with Kotlin Flow

There is a little bit change in approach how UI communicates with the ViewModel, instead directly calling its methods or properties, there are States and Events which makes the code more readable and structured. Please checkout MVI demonstration in my branch [MVI_Kotlin_Flow](https://github.com/farhanh/BaseAndroidArchitecture/tree/MVI_Kotlin_Flow) of this repository


### 3.2.2 Folder Structure

View related classes should be organized as a packe-per-feature. This means, all the
adapters, activities, fragments etc should not be in a single package for all of those. Instead, there should be a separate package for each feature containing all the related classes inside. This makes the code easier to navigate through and also easier for new people to find specific
classes when working on a specific feature.

We will be following this below given structure depicting the Note Application:

## api
* endpoints
* service
* network
* utils

## app
* ui

## common
* logging
* model
* utils

## domain
* datasource
* model
* repository
* usecase
* base

## di

### 3.3 Network

Retrofit will cover the network layer for fast and easy operations on fetching and parsing JSON data.

### 3.4 Dependency Injection

Koin is used in the base branch that uses Kotlin’s DSLs to lazily resolve your dependency graph at runtime. Please checkout Hilt demonstration in my branch [Hilt](https://github.com/farhanh/BaseAndroidArchitecture/tree/Hilt) of this repository

### 3.5 Crash Reports

Firebase Crashlytics will be used for this purpose.

### 3.6 Logging

Timber will be used for this purpose, It helps us managing how logging will work depending on the
build type (debug/release) and also contains some other helpful features like not
needing to indicate the log tag because Timber automatically detects which class is
logging.

### 3.7 Asynchronous and Event-based Functions

Coroutines/RxJava will be used for this purpose.

### 3.8 Image Loading and Caching

Glide will be used for this purpose.

### 3.9 Date and Time

ThreeTen wil be used for this purpose.

### Please Note

This is the initial version, In next versions I will try to upgrade this repository with MVI, Hilt, Kotlin Flow and many new stuff.

### Contributions to this repository are always welcome 

