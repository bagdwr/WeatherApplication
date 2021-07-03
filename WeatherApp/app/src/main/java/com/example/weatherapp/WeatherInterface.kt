package com.example.weatherapp

import com.example.weatherapp.Model.MainWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    //data/2.5/weather?q={city name}&appid={API key}
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") q:String,
        @Query("appid")appid:String
    ):MainWeather

}