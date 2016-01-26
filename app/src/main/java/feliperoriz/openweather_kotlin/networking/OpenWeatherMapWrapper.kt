package feliperoriz.openweather_kotlin.networking

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import feliperoriz.openweather_kotlin.BuildConfig
import feliperoriz.openweather_kotlin.models.OpenWeatherMapRoot
import feliperoriz.openweather_kotlin.models.WeatherEntry
import feliperoriz.openweather_kotlin.presenter.MainPresenter
import feliperoriz.openweather_kotlin.utils.createWeatherEntry
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response
import retrofit.converter.GsonConverter

/**
 * Created by feliperoriz on 1/26/16.
 */
class OpenWeatherMapWrapper : OpenWeatherApiInterface {

    val apiKey = "b85620a2d87a970c2b801e0cec8c1689"

    val unitType = "imperial"

    var presenter: MainPresenter
    var openWeatherApi: OpenWeatherApi
    var gsonBuilder: GsonBuilder
    var gson: Gson
    var weatherRestAdapter: RestAdapter

    constructor(presenter: MainPresenter) {
        this.presenter = presenter

        gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()

        weatherRestAdapter = RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org/")
                .setLogLevel(if (BuildConfig.DEBUG) RestAdapter.LogLevel.FULL else RestAdapter.LogLevel.NONE)
                .setConverter(GsonConverter(gson))
                .build()

        openWeatherApi = weatherRestAdapter.create(OpenWeatherApi::class.java)
    }


    override fun getOpenWeatherMapRoot(location: String, presenter: MainPresenter) {
        openWeatherApi.getWeatherFromApi(location,
                apiKey, unitType, WeatherCallback(location, presenter))
    }

    class WeatherCallback(var location: String, var presenter: MainPresenter) : Callback<OpenWeatherMapRoot> {

        override fun success(root: OpenWeatherMapRoot, response: Response?) {
            var weatherEntry : WeatherEntry?
            if (root.statusCode != 404) {
                weatherEntry = WeatherEntry().createWeatherEntry(location, root)
                presenter.setWeatherData(weatherEntry)
            }
        }

        override fun failure(error: RetrofitError?) {
            Log.d("WEATHER_WRAPPER_DEBUG", error.toString());
        }

    }

}


