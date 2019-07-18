package com.example.myapplication.others

import android.content.Context

class MySharedPreferences(val context: Context) {
    //Nombre del fichero
    private val fileName = "mis preferencias"
    //Instancia del fichero
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    var editor = prefs.edit()
    //Cada variable que vamos a guardar
    var name: String?
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()
    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}