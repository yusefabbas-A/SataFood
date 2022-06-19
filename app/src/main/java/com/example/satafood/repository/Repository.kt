package com.example.satafood.repository


import com.example.satafood.api.RetrofitInstance
import com.example.satafood.model.Category

import com.example.satafood.model.foodstore
import retrofit2.Response

class Repository {

    suspend fun getFoodstore(): Response<foodstore> {
        return RetrofitInstance.api.getFoodstore()
    }



}