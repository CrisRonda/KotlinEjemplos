package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.others.MySharedPreferences

/*Nunca se creara preferences y no se ejecutará hasta que variable sea
* llamada ADEMAS AL DECLARARLA FUERA DE LA CLASE ES GLOBALA EN EL PROYECTO*/
val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

class MyApp : Application() {
    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}