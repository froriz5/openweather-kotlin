package feliperoriz.openweather_kotlin.presenter

import feliperoriz.openweather_kotlin.models.WeatherEntry

/**
 * Created by feliperoriz on 1/26/16.
 */
interface MainPresenter {
    fun setWeatherMap(weatherEntry: WeatherEntry)
    fun checkWeatherEntry(weatherEntry: WeatherEntry) : WeatherEntry
    fun makeApiCall(location: String)
}