package com.infinum.isa.playground.lectureseven

import androidx.annotation.DrawableRes

//TODO: Define entity
data class SuperheroEntity(
    // TODO: Add column info and primary key
    val id: String,
    val name: String,
    @DrawableRes val imageResourceId: Int
)
