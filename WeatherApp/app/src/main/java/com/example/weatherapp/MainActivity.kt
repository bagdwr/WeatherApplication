package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.btn)
        button.setOnClickListener{
            val editText=findViewById<EditText>(R.id.etCity).text.toString().trim()
            if (editText!=null){
                val fragment=WeatherFragment(editText)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentWeatherLayout,fragment)
                    .commit()
            }
        }
    }
}