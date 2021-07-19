# Hilt Basic Usage

## Overview
I was using Koin as dependency Injection before which is now replaced by Hilt, Here I will try to explain Hilt Usage as simpler as possible.

## Reason
I found Hilt more simpler than Koin and is more close to Android-oriented implementations.

## Integration
Add the required Libraries from [Android Hilt Documentation](https://developer.android.com/training/dependency-injection/hilt-android#kts)

## Usage
### Point 1
All apps that use Hilt must contain an Application class that is annotated with @HiltAndroidApp.
```
@HiltAndroidApp
class ExampleApplication : Application() { ... }
```
### Point 2
To provide dependencies to Android classes (Activity, Fragment, View, ViewModel...), use @HiltAndroidEntryPoint
```
@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() { ... }
```
### Point 3
For instance, If you want to inject AnalyticsAdapter class in Android classes to use it like this:
```
@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {

  @Inject lateinit var analytics: AnalyticsAdapter
  ...
}
```
then you have to define Hilt bindings through constructor-injection for that AnalyticsAdapter class:
```
class AnalyticsAdapter @Inject constructor(
) { ... }
```
### Point 4 (Important)
There is one limitation, you cannot contructor-inject an interface or class which you don't own like Retrofit, Hilt provides Modules for this purpose, Let me explain you how to use it:
#### Interface Injection
For instance, If I have an interface ILogger and want to inject then there are 2 things I have to do,
 
1- Create abstract class which contain abstract funtion to return the interface:
```
@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Binds
    abstract fun bindLogger(loggerImpl: Logger): ILogger

}
```
2- Contructor Inject the implementation of ILogger:
```
class LoggerImpl @Inject contructor() : ILogger {
...
}
```
Now Logger can be used anywhere througout the Application since it has the SingletonComponent Scope:
```
@Inject
    lateinit var logger: ILogger
```
#### Inject the Class you don't own
Constructor injection is also not possible if you don't own the class because it comes from an external library (classes like Retrofit, OkHttpClient, or Room databases), or if instances must be created with the builder pattern, here you can inject an instance of AnalyticsService using @Provides annotation If you don't directly own it:
```
@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

  @Provides
  fun provideAnalyticsService(
    // Potential dependencies of this type
  ): AnalyticsService {
      return Retrofit.Builder()
               .baseUrl("https://example.com")
               .build()
               .create(AnalyticsService::class.java)
  }
}
```


### Note
I have just described the pattern here for quick usage, For further clarifications about Annotations you must checkout the [Hilt Modules Documentation](https://developer.android.com/training/dependency-injection/hilt-android#hilt-modules)
