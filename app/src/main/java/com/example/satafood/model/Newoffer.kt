package com.example.satafood.model


import com.google.gson.annotations.SerializedName

data class Newoffer(

    @SerializedName("cover")
    val cover: String,

    @SerializedName("cuisines")
    val cuisines: List<Cuisine>,

    @SerializedName("description")
    val description: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("RestauranthId")
    val restauranthId: Int
)