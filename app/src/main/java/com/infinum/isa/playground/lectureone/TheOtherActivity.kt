package com.infinum.isa.playground.lectureone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infinum.isa.playground.databinding.ActivityTheOtherBinding

class TheOtherActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_USERNAME = "EXTRA_USERNAME"
        private const val EXTRA_PASSWORD_LENGTH = "EXTRA_PASSWORD_LENGTH"

        fun buildIntent(originActivity: Activity, userName: String, passwordLength: Int): Intent {
            val intent = Intent(originActivity, TheOtherActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, userName)
            intent.putExtra(EXTRA_PASSWORD_LENGTH, passwordLength)

            return intent
        }
    }

    private lateinit var binding: ActivityTheOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTheOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.extras?.getString(EXTRA_USERNAME)
        val passwordLength = intent.extras?.getInt(EXTRA_PASSWORD_LENGTH)

        setData(userName, passwordLength)
    }

    private fun setData(userName: String?, passwordLength: Int?) {
        if (userName != null) {
            binding.usernameLabel.text = userName
        }

        if (passwordLength != null) {
            binding.passwordLengthLabel.text = "Password length: $passwordLength"
        }
    }
}