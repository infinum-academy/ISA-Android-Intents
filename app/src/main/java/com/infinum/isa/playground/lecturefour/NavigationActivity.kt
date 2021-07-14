package com.infinum.isa.playground.lecturefour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infinum.isa.playground.databinding.ActivityMainBinding
import com.infinum.isa.playground.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}