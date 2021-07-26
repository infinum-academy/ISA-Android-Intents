package com.infinum.isa.playground.lectureseven

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infinum.isa.playground.lecturethree.model.Superhero

@Dao
interface SuperheroDao {

    @Query("SELECT * FROM superhero")
    fun getAllSuperheroes() : LiveData<List<SuperheroEntity>>

    @Query("SELECT * FROM superhero WHERE id IS :superheroId")
    fun getSuperhero(superheroId: String) : LiveData<SuperheroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSuperheroes(superheroes: List<SuperheroEntity>)
}