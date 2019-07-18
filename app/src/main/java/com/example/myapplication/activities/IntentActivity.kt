package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.model.Student
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener{onBackPressed()}
        buttonExtras.setOnClickListener { goToIntentExtras() }
        buttonFlags.setOnClickListener { goToIntentFlags() }
        buttonObject.setOnClickListener { goToObject() }
    }

    private fun goToIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Cristian")
        intent.putExtra("lastName", "Ronda")
        intent.putExtra("age", 25)
        intent.putExtra("developer", true)

        startActivity(intent)
    }

    private fun goToIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY //No guarda el Activity en el Stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Borra el stack completo
        startActivity(intent)
        //finish()//Destruye el activity actual

    }

    private fun goToObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Cristian", "Ronda", 28, false)
        intent.putExtra("student",student)
        startActivity(intent)
    }
}
