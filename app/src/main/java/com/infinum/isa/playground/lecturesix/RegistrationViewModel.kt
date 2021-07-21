package com.infinum.isa.playground.lecturesix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinum.isa.playground.R
import com.infinum.isa.playground.lecturethree.model.Superhero

class RegistrationViewModel : ViewModel() {

    private val registrationResultLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun getRegistrationResultLiveData(): LiveData<Boolean> {
        return registrationResultLiveData
    }

    fun register(username: String, password: String) {
        val registrationResult = true // TODO napravi retrofit poziv
        registrationResultLiveData.value = registrationResult
    }
}