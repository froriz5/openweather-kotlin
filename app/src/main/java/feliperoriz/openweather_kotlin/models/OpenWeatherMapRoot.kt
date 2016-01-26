package feliperoriz.openweather_kotlin.models

/**
 * Created by feliperoriz on 1/26/16.
 */
class OpenWeatherMapRoot(var weather: List<OpenWeatherMapWeather>,
                              var main: OpenWeatherMapMain) : OpenWeatherMapBase(0) {

}