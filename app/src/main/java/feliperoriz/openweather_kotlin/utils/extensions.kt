package feliperoriz.openweather_kotlin.utils

import feliperoriz.openweather_kotlin.models.OpenWeatherMapRoot
import feliperoriz.openweather_kotlin.models.WeatherEntry
/**
 * Created by feliperoriz on 1/26/16.
 */

fun WeatherEntry.createWeatherEntry(location: String, root: OpenWeatherMapRoot) : WeatherEntry {
    val weatherEntry = WeatherEntry(
            location,
            root.main.currentTemp,
            root.main.low,
            root.main.max,
            root.weather[0].description
    )
    return weatherEntry
}
