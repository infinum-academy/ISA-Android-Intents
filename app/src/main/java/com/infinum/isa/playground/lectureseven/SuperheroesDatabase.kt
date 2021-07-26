package com.infinum.isa.playground.lectureseven

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        SuperheroEntity::class
    ],
    version = 1
)
abstract class SuperheroesDatabase : RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: SuperheroesDatabase? = null

        fun getDatabase(context: Context): SuperheroesDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context,
                    SuperheroesDatabase::class.java,
                    "superheroes_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = database
                database
            }
        }
    }

    abstract fun superheroDao(): SuperheroDao
}