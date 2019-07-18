package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.adapters.PersonAdapter
import com.example.myapplication.model.Person
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : ToolbarActivity() {
    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener{onBackPressed()}
        personList = getPerson()
        adapter = PersonAdapter(this, R.layout.list_view_person, personList)
        listView.adapter = adapter
    }

    private fun getPerson(): List<Person> {
        var listPerson = listOf(
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25),
            Person("Cristian", "Ronda", 25),
            Person("Zaira", "Ronda", 8),
            Person("Jorge", "Ronda", 45),
            Person("Amelia", "Sangovalin", 40),
            Person("Ricardo", "Sarmiento", 25)
        )
        return listPerson
    }

}
