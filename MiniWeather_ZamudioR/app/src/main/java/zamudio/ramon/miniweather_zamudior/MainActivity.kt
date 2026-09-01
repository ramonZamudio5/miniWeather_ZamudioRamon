package zamudio.ramon.miniweather_zamudior

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val greeting : TextView = findViewById<TextView>(R.id.tvGreeting)
        val city : TextView = findViewById<TextView>(R.id.tvCity)
        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        val temperature = findViewById<TextView>(R.id.tvTemperature)
        val tvWeather = findViewById<TextView>(R.id.tvWeather)


    }
}