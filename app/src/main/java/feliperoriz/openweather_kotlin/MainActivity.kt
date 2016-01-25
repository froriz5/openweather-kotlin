package feliperoriz.openweather_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "Changed Hello World!"
        button.setOnClickListener(mButtonClicked)
    }

    val mButtonClicked: View.OnClickListener = View.OnClickListener {
        textView.text = "Button Clicked"
    }
}
