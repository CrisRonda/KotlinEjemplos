package com.example.myapplication.others

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_life_cycle.*

open class LifeCycleEventsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("ONCREATE","ONCREATE")
        Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.w("ONCREATE","onStart")
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Log.w("ONCREATE","onResume")

        Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show()

    }

    override fun onPause() {
        super.onPause()
        Log.w("ONCREATE","OnPause")
        Toast.makeText(this, "OnPause", Toast.LENGTH_LONG).show()

    }

    override fun onStop() {
        super.onStop()
        Log.w("ONCREATE","OnStop")

        Toast.makeText(this, "OnStop", Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("ONCREATE","OnDestroy")

        Toast.makeText(this, "OnDestroy", Toast.LENGTH_LONG).show()

    }

    override fun onRestart() {
        super.onRestart()
        Log.w("ONCREATE","OnRestart")

        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show()
    }


}


