package com.infinum.isa.playground.lecturefour

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.infinum.isa.playground.R

class HomeHeaderFragment : Fragment(R.layout.fragment_home_header) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val someInt = requireArguments().getInt("someInt")
        if (someInt == 8) {
            Toast.makeText(context, "E bok nos ti posran", Toast.LENGTH_SHORT).show()
        }
    }
}