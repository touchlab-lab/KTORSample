package co.touchlab.ktorsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.touchlab.shared.DogAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DogAPI().getRandomDog {
            result_text.text = it
        }
    }
}
