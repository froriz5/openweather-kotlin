package feliperoriz.openweather_kotlin

import android.support.v7.app.AppCompatActivity
import kotlin.String
import android.os.Bundle
import android.view.View
import android.widget.Toast
import feliperoriz.openweather_kotlin.models.WeatherEntry
import feliperoriz.openweather_kotlin.presenter.MainPresenter
import feliperoriz.openweather_kotlin.presenter.MainPresenterImpl
import feliperoriz.openweather_kotlin.view.MainView
import kotlinx.android.synthetic.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this)

        button.setOnClickListener({
            var location = editText.text.toString()
            location = if (location.length > 1) location.capitalize() else "Chicago"
            presenter?.makeApiCall(location)
        })
    }

    override fun setWeatherData(weatherEntry: WeatherEntry) {
        var weatherEntryToString = weatherEntry.toString()
        if (weatherEntryToString.equals("")) {
            textView.text = ""
            Toast.makeText(this, "Invalid City Name", Toast.LENGTH_LONG).show()
        }
        else {
            textView.text = weatherEntryToString
        }
    }
}
