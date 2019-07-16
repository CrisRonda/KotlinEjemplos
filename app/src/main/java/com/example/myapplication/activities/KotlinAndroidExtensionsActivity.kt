package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)
        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click By ID", Toast.LENGTH_LONG).show() }
        buttonByKAT.setOnClickListener { Toast.makeText(this, "Click By KAT", Toast.LENGTH_LONG).show() }
    }
}
