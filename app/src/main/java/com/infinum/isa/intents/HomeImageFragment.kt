package com.infinum.isa.intents

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeImageFragment : Fragment(R.layout.fragment_home_image) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        if (someInt == 0) {
            Toast.makeText(context, "I have received some data", Toast.LENGTH_SHORT).show()
        }
    }
}