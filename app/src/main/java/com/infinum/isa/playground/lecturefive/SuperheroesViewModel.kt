package com.infinum.isa.playground.lecturefive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinum.isa.playground.PlaygroundApp
import com.infinum.isa.playground.R
import com.infinum.isa.playground.lectureseven.SuperheroEntity
import com.infinum.isa.playground.lectureseven.SuperheroesDatabase
import com.infinum.isa.playground.lecturethree.model.Superhero
import java.util.concurrent.Executors

class SuperheroesViewModel(
    val database: SuperheroesDatabase
) : ViewModel() {

    fun getAllSuperheroes(): LiveData<List<SuperheroEntity>> {
        return database.superheroDao().getAllSuperheroes()
    }

    fun addSuperhero(superhero: Superhero) {
        Executors.newSingleThreadExecutor().execute {
            database.superheroDao().insertAllSuperheroes(
                listOf(SuperheroEntity("123", superhero.name, superhero.imageResourceId))
            )
        }
    }
}