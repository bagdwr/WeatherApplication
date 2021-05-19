package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

class Weather(
      @SerializedName("id") val id:Long,
      @SerializedName("main")val main:String,
      @SerializedName("description")val description:String,
      @SerializedName("icon")val icon:String
){
      fun getString(): String {
            return "$main, $description"
      }
}