package com.infinum.isa.playground.lecturethree.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.ActivitySuperherosBinding
import com.infinum.isa.playground.lecturethree.model.Superhero

class SuperherosActivity : AppCompatActivity() {

    companion object {

        fun buildIntent(context: Activity): Intent {
            return Intent(context, SuperherosActivity::class.java)
        }
    }

    private val superheros = listOf(
        Superhero("Hrvatko", R.drawable.hrvatko),
        Superhero("Captain Marvel", R.drawable.captain_marvel),
        Superhero("Wonder Woman", R.drawable.wonder_woman),
        Superhero("Cat woman", R.drawable.cat_woman),
        Superhero("Flash", R.drawable.flash),
        Superhero("Hulk", R.drawable.hulk),
        Superhero("Ironman", R.drawable.iron_man),
        Superhero("Spiderman", R.drawable.spiderman),
        Superhero("Superman", R.drawable.superman),
        Superhero("TMNT", R.drawable.tmnt)
    )

    private lateinit var binding: ActivitySuperherosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuperherosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Create recycler view with adapter and layout manager

        // TODO: Connect load items button

        // TODO: Connect add superhero button
    }
}