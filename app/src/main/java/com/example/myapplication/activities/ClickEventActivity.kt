package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_click_event.*

class ClickEventActivity : ToolbarActivity(), View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_event)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener{onBackPressed()}
        clickInLine()
        clickMulti1()
        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    //Reglas para botones XML
    // Metodo publico y con el mismo nombre aqui y en el xml
    // SOLO RECIBE UN PARAMETRO
    fun xmlClick(view: View) {
        Toast.makeText(this, "XML Click", Toast.LENGTH_LONG).show()
    }

    private fun clickInLine() {
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { Toast.makeText(this, "Click in Line", Toast.LENGTH_LONG).show() }
    }

    private fun clickMulti1() {
        val btn = findViewById<Button>(R.id.buttonClickMulti1)
        btn.setOnClickListener{Toast.makeText(this, "Click normal", Toast.LENGTH_LONG).show()}

    }

    override fun onLongClick(view: View): Boolean {
        when (view.id) {
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Multi 1 Click", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Multi 2 Click", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Multi 2 Click", Toast.LENGTH_LONG).show()
        }
        return true
    }

}
