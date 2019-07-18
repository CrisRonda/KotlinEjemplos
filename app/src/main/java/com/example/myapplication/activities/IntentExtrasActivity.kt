package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.model.Student
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener{onBackPressed()}
        val isParcelableSet = setParcelableExtrasFromPreviuosIntent()
        val isExtraSet = setIntentExtrasFromPreviousIntent()
        if (!isParcelableSet && !isExtraSet) {
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
        //buttonBack.setOnClickListener{startActivity(Intent(this, IntentActivity::class.java))}
    }

    private fun setParcelableExtrasFromPreviuosIntent(): Boolean {
        var student = intent.getParcelableExtra<Student>("student")
        student?.let {
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = student.age.toString()
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false

    }

    private fun setIntentExtrasFromPreviousIntent(): Boolean {
        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")
        val age = intent.getIntExtra("age", 26)
        val developer = intent.getBooleanExtra("developer", false)
        if (name != null && lastName != null && age > 0) {
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = age.toString()
            checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }
}
