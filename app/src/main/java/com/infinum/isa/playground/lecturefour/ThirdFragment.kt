package com.infinum.isa.playground.lecturefour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.FragmentFirstBinding
import com.infinum.isa.playground.databinding.FragmentSecondBinding
import com.infinum.isa.playground.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    // TODO add click listener that navigates to first fragment

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}