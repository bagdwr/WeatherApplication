package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.Model.MainWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherFragment(
    val cityName:String
):Fragment() {
    private var weatherInterface:WeatherInterface?=null
    private var retrofit:Retrofit?=null
    private val apiKey="523f039df74c6dc3d146d773b2ea21e3"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather,null,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        retrofit=Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        weatherInterface=retrofit?.create(WeatherInterface::class.java)
        getWeather()
        Log.i("onViewCreated():","Error")
    }
    fun bind(weather:MainWeather){
        val cityName=view?.findViewById<TextView>(R.id.tvCityName)
        val countryName=view?.findViewById<TextView>(R.id.tvCountryName)
        val lon=view?.findViewById<TextView>(R.id.tvLon)
        val lat=view?.findViewById<TextView>(R.id.tvLat)
        val MAIN=view?.findViewById<TextView>(R.id.tvMain)
        val description=view?.findViewById<TextView>(R.id.tvDescription)
        val temp=view?.findViewById<TextView>(R.id.tvTemp)
        val feelsTemp=view?.findViewById<TextView>(R.id.tvFeelsLike)

        cityName!!.text="Город:${weather.name}"
        countryName!!.text="Страна:${weather.sys.country}"
        lon!!.text="Широта:${weather.coord.lon}"
        lat!!.text="Долгота:${weather.coord.lat}"
        MAIN!!.text="Погода:${weather.weather.main}"
        description!!.text="Описание:${weather.weather.description}"
        temp!!.text="Температура:${(weather.main.temp-273.15)}"
        feelsTemp!!.text="Ощущение:${(weather.main.feels_like-273.15)}"
        Log.i("bind():","Error")

    }


    fun getWeather(){
        val call=weatherInterface?.getWeather(
            cityName,
            apiKey
        )
        call?.enqueue(object: Callback<MainWeather>{
            override fun onResponse(call: Call<MainWeather>, response: Response<MainWeather>) {
                response?.body().let {
                    bind(it as MainWeather)
                }
            }

            override fun onFailure(call: Call<MainWeather>, t: Throwable) {
                Log.i("getWeather():","$t")
                t.printStackTrace()
                Toast.makeText(requireContext(), "Error: $t", Toast.LENGTH_LONG).show()
            }

        })

    }
}