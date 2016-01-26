package feliperoriz.openweather_kotlin.view

import feliperoriz.openweather_kotlin.models.WeatherEntry

/**
 * Created by feliperoriz on 1/26/16.
 */
interface MainView {
    fun setWeatherData(weatherEntry: WeatherEntry)
}