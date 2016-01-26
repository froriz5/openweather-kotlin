package feliperoriz.openweather_kotlin.presenter

import feliperoriz.openweather_kotlin.models.WeatherEntry
import feliperoriz.openweather_kotlin.networking.OpenWeatherMapWrapper
import feliperoriz.openweather_kotlin.view.MainView

/**
 * Created by feliperoriz on 1/26/16.
 */
class MainPresenterImpl: MainPresenter {
    
    var view: MainView
    var wrapper: OpenWeatherMapWrapper

    constructor(view: MainView) {
        this.view = view
        wrapper = OpenWeatherMapWrapper(this)
    }

    override fun setWeatherData(weatherEntry: WeatherEntry) {
        view.setWeatherData(weatherEntry)
    }

    override fun checkWeatherEntry(weatherEntry: WeatherEntry): WeatherEntry {
        var weather: WeatherEntry
        if (weatherEntry == null) {
            weather = WeatherEntry("", 0.0, 0.0, 0.0, "")
            return weather
        }
        return weatherEntry
    }

    override fun makeApiCall(location: String) {
        wrapper.getOpenWeatherMapRoot(location, this)
    }
}
