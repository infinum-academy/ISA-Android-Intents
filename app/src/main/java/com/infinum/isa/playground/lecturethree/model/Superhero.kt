package com.infinum.isa.playground.lecturethree.model

import androidx.annotation.DrawableRes

data class Superhero(
    val name: String,
    @DrawableRes val imageResourceId: Int
)
