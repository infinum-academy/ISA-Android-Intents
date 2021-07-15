package com.infinum.isa.playground.lectureone

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.infinum.isa.playground.R
import com.infinum.isa.playground.databinding.ActivityMainBinding
import com.infinum.isa.playground.lecturefour.HomeHeaderFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAcademyTitle()
        setPressMeClickListener()

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val bundle = bundleOf("someInt" to 8)
                add<HomeHeaderFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
    }

    private fun setAcademyTitle() {
        binding.helloLabel.text = "Djevojka sa sela s mojim štiklama"
    }

    private fun setPressMeClickListener() {
        binding.implicitIntentButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startValidUrlIntent()
            }
        })

        binding.explicitIntentButton.setOnClickListener {
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