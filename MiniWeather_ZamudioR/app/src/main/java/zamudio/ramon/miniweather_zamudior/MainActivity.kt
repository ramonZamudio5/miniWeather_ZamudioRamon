package zamudio.ramon.miniweather_zamudior

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import utilities.WeatherService
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private lateinit var greeting : TextView

    override fun onCreate(savedInstanceState: Bundle? ) {
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        greeting = findViewById<TextView>(R.id.tvGreeting)
        val city : TextView = findViewById<TextView>(R.id.tvCity)
        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        val temperature = findViewById<TextView>(R.id.tvTemperature)
        val tvWeather = findViewById<TextView>(R.id.tvWeather)


        val citySelected = intent.getStringExtra("city")
        val time = LocalTime.now().hour
        when(time) {
            in 5..11 -> greeting.text = getString(R.string.good_morning)
            in 12..19 -> greeting.text = getString(R.string.good_afternoon)
            else -> greeting.text = getString(R.string.good_evening)
        }
        val weatherSerice : WeatherService = WeatherService(this)
        val weather = weatherSerice.getWeather(citySelected)
        temperature.text = "${weather.temperature.toString()}°C"
        city.text = citySelected
        tvWeather.text = weather.Weather
        when (weather.Weather){
            getString(R.string.stormy) -> ivWeather.setImageResource(R.drawable.ic_stormy)
            getString(R.string.cloudy) -> ivWeather.setImageResource(R.drawable.ic_cloudy)
            getString(R.string.windy) -> ivWeather.setImageResource(R.drawable.ic_windy)
            getString(R.string.snowy) -> ivWeather.setImageResource(R.drawable.ic_snowy)
            getString(R.string.rainy) -> ivWeather.setImageResource(R.drawable.ic_rainy)
            getString(R.string.sunny) -> ivWeather.setImageResource(R.drawable.ic_sunny)
        }
    }

    override fun onResume() {
        super.onResume()
        actualizarSaludo()
    }

    private fun actualizarSaludo() {
        val time = LocalTime.now().hour
        when(time) {
            in 5..11 -> greeting.text = getString(R.string.good_morning)
            in 12..19 -> greeting.text = getString(R.string.good_afternoon)
            else -> greeting.text = getString(R.string.good_evening)
        }
    }




}