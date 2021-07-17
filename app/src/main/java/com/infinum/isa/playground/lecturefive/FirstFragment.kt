package com.infinum.isa.playground.lecturefive

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.infinum.isa.playground.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO Add action from 1 to 3 in graph and attach it to click listener
        binding.goToTwoButton.setOnClickListener {
            navigateToSecondFragment()
        }

        //TODO Implement a check if we can automatically navigate forward
    }

    private fun navigateToSecondFragment() {
        val action = FirstFragmentDirections.actionFirstToSecond(9)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Toast.makeText(context, "FLO: $this", Toast.LENGTH_LONG).show()
    }
}