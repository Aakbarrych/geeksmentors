package kg.geeks.geeksmentor.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(kg.geeks.geeksmentor.R.layout.activity_splash)
        Handler().postDelayed({startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}