package com.infinum.isa.playground

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.infinum.isa.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // TODO: Define binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Set text
        setAcademyTitle()
        // TODO: Set click listener
        setPressMeClickListener()
    }

    private fun setAcademyTitle() {
        binding.helloLabel.text = "Djevojka sa sela s mojim štiklama"
    }

    private fun setPressMeClickListener() {
        binding.implicitIntentButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO: Do something implicit
                startValidUrlIntent()
            }
        })

        binding.explicitIntentButton.setOnClickListener {
            // TODO: Start explicit intent (but to where? create a new activity!)
            startExplicitIntent()
        }
    }

    private fun startInvalidUrlIntent() {
        val uri = Uri.parse("ovo_nece://radit")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        // This will go boom with an ActivityNotFoundException
        startActivity(intent)
    }

    private fun startValidUrlIntent() {
        try {
            val uri = Uri.parse("https://academy.infinum.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Nismo uspjeli otvoriti link", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startExplicitIntent() {
        val intent = TheOtherActivity.buildIntent(
            originActivity = this,
            userName = binding.usernameInput.text.toString(),
            passwordLength = binding.passwordInput.text?.toString().orEmpty().length
        )

        startActivity(intent)
    }
}