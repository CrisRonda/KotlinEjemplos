package com.example.myapplication.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.others.LifeCycleEventsActivity
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnable = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener{onBackPressed()}
    }

    override fun onBackPressed() {
        if (exitEnable) super.onBackPressed()
        exitEnable = true
        Toast.makeText(this, "Presiona atrás de nuevo", Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { exitEnable = false }, 2000)
    }
}

