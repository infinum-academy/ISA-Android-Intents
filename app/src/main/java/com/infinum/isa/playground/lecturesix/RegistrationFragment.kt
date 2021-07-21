package com.infinum.isa.playground.lecturesix

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
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.location.LocationServices
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.FragmentRegistrationBinding
import com.infinum.isa.playground.databinding.FragmentSecondBinding

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRegistrationResultLiveData().observe(this.viewLifecycleOwner) { isRegisterSuccessful ->
            if (isRegisterSuccessful) {
                Toast.makeText(context, "USPJEŠNA REGISTRACIJA", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "NIJE USPJEŠNA REGISTRACIJA", Toast.LENGTH_SHORT).show()
            }
        }
        binding.apply {
            registerButton.setOnClickListener {
                viewModel.register(usernameInput.text.toString(), passwordInput.text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}