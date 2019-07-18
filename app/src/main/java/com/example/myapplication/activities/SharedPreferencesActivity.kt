package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.app.preferences
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener { onBackPressed() }
        getValuesSharedPreferences()
        buttonSave.setOnClickListener { setValuesSharedPreferences();cleanEditText(); getValuesSharedPreferences() }
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name!!.isEmpty() && preferences.age <=0) {
            textViewSharedPreferences.text = "Hola! Ingresa tu nombre y edad."
        } else {
            textViewSharedPreferences.text = "Bienvenido ${preferences.name} y tu edad es ${preferences.age}"
        }
    }

    private fun setValuesSharedPreferences() {
        if (editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()) {
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this,"Los valores se guardaron correctamente",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Llena los datos primero",Toast.LENGTH_LONG).show()
        }
    }

    private fun cleanEditText() {
        editTextName.text.clear()
        editTextAge.text.clear()
    }

}
