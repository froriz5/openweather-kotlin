package feliperoriz.openweather_kotlin.networking

import feliperoriz.openweather_kotlin.models.OpenWeatherMapRoot
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by feliperoriz on 1/26/16.
 */
interface OpenWeatherApi {

    @GET("/data/2.5/weather")
    fun getWeatherFromApi(
            @Query("q") location: String,
            @Query("APPID") apiKey: String,
            @Query("units") units: String,
            callback: Callback<OpenWeatherMapRoot>)
}