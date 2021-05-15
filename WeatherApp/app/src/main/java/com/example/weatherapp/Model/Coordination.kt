package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

class Coordination(
    @SerializedName("lon")val lon:Double,
    @SerializedName("lat")val lat:Double
) {
}