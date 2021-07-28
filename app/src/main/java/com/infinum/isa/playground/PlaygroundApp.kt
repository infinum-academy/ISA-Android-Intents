package com.infinum.isa.playground

import android.app.Application
import com.infinum.isa.playground.lectureseven.SuperheroEntity
import com.infinum.isa.playground.lectureseven.SuperheroesDatabase
import com.infinum.isa.playground.lecturethree.model.Superhero
import java.util.concurrent.Executors

class PlaygroundApp : Application() {

    // TODO: Create database by lazy
    val superheroesDatabase by lazy {
        SuperheroesDatabase.getDatabase(this)
    }

    private val superheros = listOf(
        SuperheroEntity("1","Hrvatko", R.drawable.hrvatko),
        SuperheroEntity("2","Captain Marvel", R.drawable.captain_marvel),
        SuperheroEntity("3","Wonder Woman", R.drawable.wonder_woman),
        SuperheroEntity("4","Cat woman", R.drawable.cat_woman),
        SuperheroEntity("5","Flash", R.drawable.flash),
        SuperheroEntity("6","Hulk", R.drawable.hulk),
        SuperheroEntity("7","Ironman", R.drawable.iron_man),
        SuperheroEntity("8","Spiderman", R.drawable.spiderman),
        SuperheroEntity("9","Superman", R.drawable.superman),
        SuperheroEntity("10","TMNT", R.drawable.tmnt)
    )

    override fun onCreate() {
        super.onCreate()

        Executors.newSingleThreadExecutor().execute {
            superheroesDatabase.superheroDao().insertAllSuperheroes(superheros)
        }
    }
}