package com.infinum.isa.playground.lecturefive

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.location.LocationServices
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val args: SecondFragmentArgs by navArgs()

    // TODO Create needed permission contract, also add permission to manifest


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            findNavController().navigate(R.id.action_second_to_third)
        }

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean("vec sam na drugom fragmentu", true)
            apply()
        }

        //TODO Ask for permission to show current coordinates
    }

    /**
     * Ovdje smo suppresali warning od android studia jer garantiramo da će se
     * permission provjeriti preko [locationPermissionForCoordinates]
     */
    @SuppressLint("MissingPermission")
    private fun showCoordinates() {
        LocationServices.getFusedLocationProviderClient(activity).lastLocation.addOnSuccessListener {
            binding.coordinates.text = getString(R.string.coordinates).format(it.latitude, it.longitude)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}