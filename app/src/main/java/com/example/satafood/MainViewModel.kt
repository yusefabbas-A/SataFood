package com.example.satafood

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.satafood.model.foodstore
import com.example.satafood.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<foodstore>> = MutableLiveData()

    fun getFoodstore(){
        viewModelScope.launch {
            val response = repository.getFoodstore()
            myResponse.value = response
        }
    }


}