package feliperoriz.openweather_kotlin.models

/**
 * Created by feliperoriz on 1/26/16.
 */

data class WeatherEntry(var location: String = "Chicago", var currentTemp: Double = 72.0,
                   var low: Double = 60.0, var high: Double = 75.0, var description: String = "Cloudy",
                        var toString: String =
                        "$location ---- Current: $currentTemp --- Low: $low --- High: $high") {


    override fun toString(): String {
        return toString
    }

    fun changeToString(string: String) {
        toString = string
    }
}
