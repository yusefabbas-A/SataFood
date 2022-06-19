package com.example.satafood.api


import com.example.satafood.model.Category
import com.example.satafood.model.foodstore
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("/api/branches/homepage")
    suspend fun getFoodstore(): Response<foodstore>


}