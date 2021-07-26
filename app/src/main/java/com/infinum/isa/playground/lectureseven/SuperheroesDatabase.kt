package com.infinum.isa.playground.lectureseven

import android.content.Context

// TODO: Define database
abstract class SuperheroesDatabase {

    companion object {

        @Volatile
        private var INSTANCE: SuperheroesDatabase? = null

        fun getDatabase(context: Context): SuperheroesDatabase? {
            // TODO: create a database once the app starts
            return null
        }
    }

    // TODO: Define DAO
}