package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.model.Person
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter(val context: Context, val layout: Int, val list: List<Person>) : BaseAdapter() {

    private val mInflator: LayoutInflater = LayoutInflater.from(context)
    override fun getItem(position: Int): Any {
        return list[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, converView: View?, parentViewGroup: ViewGroup?): View {
        /*
        SI converView ES VACIO LA PRIMERA VEZ
        * view -> es el item de la lista que se va a dibujar
        * viewHolder -> Son los elementos del item de la lista
        * converView -> La primera vez que se dibuja esta vacio por lo que tenemos que inflarlo/llenar la vista
        * Agregamos los elementos del viewHolder al view
        * view.tag -> Inyectamos un objeto a un View en general y guardamos el viewHolder con las referencias de los TextView
        * para luego guardar el primer objeto Persona
        *
        * SINO ESTA VACIO (para el segundo en adelante de los objetos)
        * Guardamos en el view el convertView con los objectos anteriores
        * Extraemos el tag del viewHolder para obtener las referencias de los TextView
        *
        * Y PRESENTAMOS LOS VALORES EN LOS TEXT
        * */

        val view: View
        val viewHolder: PersonViewHolder
        if (converView == null) {
            view = mInflator.inflate(layout, parentViewGroup, false)
            viewHolder = PersonViewHolder(view) //Asignamos las referencias al view con textos
            view.tag = viewHolder
        } else {
            view = converView
            viewHolder = view.tag as PersonViewHolder
        }
        val fullName = "${list[position].firstName} ${list[position].lastName}"
        viewHolder.fullName.text = fullName
        viewHolder.age.text = "${list[position].age}"
        return view
    }
}

//PATRON DE DISEÑO HOLDER - Lista de la UI del item de la lista
private class PersonViewHolder(view: View) {
    val fullName: TextView = view.textViewName
    val age: TextView = view.textViewAge

}
