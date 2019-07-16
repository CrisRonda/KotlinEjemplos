package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import com.example.myapplication.activities.*
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExt = findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnIntent = findViewById<Button>(R.id.button_to_intent)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.button_to_extension_functions)
        btnLifeCycle.setOnClickListener { goToLifeCycleActivity() }
        btnClickEvents.setOnClickListener { goToClickEventActivity() }
        btnAndroidExt.setOnClickListener { goToKotlinAndroidExtensionsActivity() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntent.setOnClickListener { goToIntentActivity() }
        btnPermission.setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctionsActivity() }

    }

    private fun goToLifeCycleActivity() = startActivity(Intent(this, LifeCycleActivity::class.java))
    private fun goToClickEventActivity() = startActivity(Intent(this, ClickEventActivity::class.java))
    private fun goToKotlinAndroidExtensionsActivity() =
        startActivity(Intent(this, KotlinAndroidExtensionsActivity::class.java))

    private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
    private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
    private fun goToIntentActivity() = startActivity(Intent(this, IntentActivity::class.java))
    private fun goToPermissionsActivity() = startActivity(Intent(this, PermissionsActivity::class.java))
    private fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
    private fun goToExtensionFunctionsActivity() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))


    fun showToast() {
        Toast.makeText(this, "Hola!", Toast.LENGTH_LONG).show()
    }

    fun showSnackBar() {
        val layout = findViewById<ConstraintLayout>(R.id.constraint)
        Snackbar.make(layout, "Hola desde el SnackBar", Snackbar.LENGTH_LONG).setAction("UNDO") {
            Snackbar.make(layout, "Restablecido", Snackbar.LENGTH_LONG).show()
        }.show()
    }
}
