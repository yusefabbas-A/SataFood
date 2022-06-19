package com.example.satafood.model


import com.google.gson.annotations.SerializedName


data class foodstore(

    @SerializedName("categories")
    val categories: List<Category>,

    @SerializedName("newoffers")
    val newoffers: List<Newoffer>,

    @SerializedName("sliders")
    val sliders: List<Slider>
)