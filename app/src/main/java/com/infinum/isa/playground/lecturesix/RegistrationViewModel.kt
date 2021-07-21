package com.infinum.isa.playground.lecturesix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinum.isa.playground.R
import com.infinum.isa.playground.lecturesix.models.RegisterRequest
import com.infinum.isa.playground.lecturesix.models.RegisterResponse
import com.infinum.isa.playground.lecturesix.networking.ApiModule
import com.infinum.isa.playground.lecturethree.model.Superhero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel : ViewModel() {

    private val registrationResultLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun getRegistrationResultLiveData(): LiveData<Boolean> {
        return registrationResultLiveData
    }

    fun register(username: String, password: String) {
        ApiModule.retrofit.register(RegisterRequest(username, password, password)).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                registrationResultLiveData.value = true
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                registrationResultLiveData.value = false
            }
        })
    }
}