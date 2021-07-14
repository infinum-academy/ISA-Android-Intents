package com.infinum.isa.playground.lecturethree.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.ActivitySuperherosBinding
import com.infinum.isa.playground.databinding.DialogAddSuperheroBinding
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

    private var superherosAdapter: SuperherosAdapter? = null

    // TODO Instanciraj VM ovdje

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuperherosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSuperherosRecycler()

        // TODO "osluškuj" promjene u listi superheroja iz VMa

        initLoadItemsButton()
        initAddSuperheroButton()
    }

    private fun initSuperherosRecycler() {
        superherosAdapter = SuperherosAdapter(emptyList()) { item ->
            Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        }

        binding.superherosRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.superherosRecyclerView.adapter = superherosAdapter

        binding.superherosRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun initLoadItemsButton() {
        // TODO nek ova funkcija prima listu superheroja umjesto da su zahardkodirani
        binding.loadItemsButton.setOnClickListener {
            superherosAdapter?.setItems(superheros)
            binding.emptyStateLabel.isVisible = false
            binding.superherosRecyclerView.isVisible = true
        }
    }

    private fun initAddSuperheroButton() {
        binding.addSuperheroButton.setOnClickListener {
            showAddSuperheroBottomSheet()
        }
    }

    private fun showAddSuperheroBottomSheet() {
        val dialog = BottomSheetDialog(this)

        val bottomSheetBinding = DialogAddSuperheroBinding.inflate(layoutInflater)
        dialog.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.confirmButton.setOnClickListener {
            addSuperheroToList(bottomSheetBinding.nameInput.text.toString())
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun addSuperheroToList(name: String) {
        // TODO zakomentiraj ovu ispod funkciju i pozovi VM da doda novog superheroja i azurira listu
        // TODO testiraj orientation change
        superherosAdapter?.addItem(Superhero(name, R.drawable.ic_placeholder))
    }
}