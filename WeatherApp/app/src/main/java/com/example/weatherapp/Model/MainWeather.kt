package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

class MainWeather(
    @SerializedName("coord")val coord:Coordination,
    @SerializedName("weather")val weather:Weather,
    @SerializedName("main")val main:Main,
    @SerializedName("sys")val sys:Sys,
    @SerializedName("name")val name:String
)