package Adaptadores

import Modelo.Tarea
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetareas.R

class MiAdaptador (private var context: Context,
                   private var tareas : ArrayList<Tarea>
) :
RecyclerView.Adapter<MiAdaptador.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.id.text = tareas[position].id
        holder.autor.text = tareas[position].autor
        holder.fecha.text = tareas[position].fecha
        holder.hora.text = tareas[position].hora
        holder.descripcion.text = tareas[position].descripcion



        holder.itemView.setOnClickListener {
//            Toast.makeText(context, personas[position].dni, Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return tareas.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView = itemView.findViewById<View>(R.id.txtId) as TextView
        var autor: TextView = itemView.findViewById<View>(R.id.txtAutor) as TextView
        var fecha: TextView = itemView.findViewById<View>(R.id.txtFecha) as TextView
        var hora: TextView = itemView.findViewById<View>(R.id.txtHora) as TextView
        var descripcion: TextView = itemView.findViewById<View>(R.id.txtDescripcion) as TextView
//        var hechas: RadioButton = itemView.findViewById<View>(R.id.rboFiltComple) as RadioButton
//        var urgentes: RadioButton = itemView.findViewById<View>(R.id.rboFiltUrge) as RadioButton
//        var pospuestas: RadioButton = itemView.findViewById<View>(R.id.rboFiltPostpuestas) as RadioButton
    }
}