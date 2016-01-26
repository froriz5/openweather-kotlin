package feliperoriz.openweather_kotlin.networking

import feliperoriz.openweather_kotlin.presenter.MainPresenter

/**
 * Created by feliperoriz on 1/26/16.
 */
interface OpenWeatherApiInterface {
    fun getOpenWeatherMapRoot(location: String, presenter: MainPresenter)
}