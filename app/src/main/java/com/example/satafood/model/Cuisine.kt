package com.example.satafood.model

import com.google.gson.annotations.SerializedName


data class Cuisine(

    @SerializedName("name")
    val name: String
)