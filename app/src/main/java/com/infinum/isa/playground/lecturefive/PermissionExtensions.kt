package com.infinum.isa.playground.lecturefive

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import com.infinum.isa.playground.R

//TODO create extension for requesting permissions

/**
 * Displays the default Snackbar with Action to open the Application Details
 * in Settings so the user can enable permissions.
 */
private fun showPermissionsDeniedSnackbar(
    fragmentActivity: FragmentActivity,
    message: String = fragmentActivity.getString(R.string.no_permission)
) {
    fragmentActivity.apply {
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        )
            .setAction(
                R.string.settings
            ) { startActivity(getApplicationSettingsIntent(this)) }.show()
    }
}

/**
 * Creates an intent for the application details in settings.
 */
private fun getApplicationSettingsIntent(
    fragmentActivity: FragmentActivity
): Intent {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    intent.data = Uri.parse("package:${fragmentActivity.packageName}")
    return intent
}