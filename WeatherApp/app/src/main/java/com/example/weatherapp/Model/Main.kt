package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

//"main":{
//    "temp":306.15,
//    "feels_like":303.87,
class Main(
    @SerializedName("temp")val temp:Double,
    @SerializedName("feels_like")val feels_like:Double
)