package com.infinum.isa.playground.lecturethree.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.ActivitySuperherosBinding
import com.infinum.isa.playground.lecturethree.model.Superhero

class SuperherosActivity : AppCompatActivity() {

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

        initSuperherosRecycler()
    }

    private fun initSuperherosRecycler() {
        binding.superherosRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.superherosRecyclerView.adapter = SuperheroAdapter(superheros) { item ->
            Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        }
    }
}