package com.infinum.isa.playground.lectureseven

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infinum.isa.playground.lecturefive.SuperheroesViewModel
import java.lang.IllegalArgumentException

class SuperheroViewModelFactory(val database: SuperheroesDatabase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SuperheroesViewModel::class.java)) {
            return SuperheroesViewModel(database) as T
        }
        throw IllegalArgumentException("Sorry, ne mozemo radit s ne SuperheroesViewModel klasama")
    }
}