package com.damarispicado.registromuseo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaListAdapter  internal constructor(
    context: Context
) : RecyclerView.Adapter<PersonaListAdapter.PersonaViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var personas = emptyList<Persona>() // Cached copy of words

    inner class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombreItemView: TextView = itemView.findViewById(R.id.textView)
        val apellidoItemView: TextView = itemView.findViewById(R.id.textView2)
        val sexoItemView: TextView = itemView.findViewById(R.id.textView3)
        val etniaItemView: TextView = itemView.findViewById(R.id.textView4)
        val identificacionItemView: TextView = itemView.findViewById(R.id.textView5)
        val direccionItemView: TextView = itemView.findViewById(R.id.textView6)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PersonaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val current = personas[position]
        holder.nombreItemView.text = current.nombre
        holder.apellidoItemView.text = current.apellido
        holder.sexoItemView.text = current.sexo
        holder.etniaItemView.text = current.etnia
        holder.identificacionItemView.text = current.identificacion
        holder.direccionItemView.text = current.direccion


    }

    internal fun setPersonas(personas: List<Persona>) {
        this.personas= personas
        notifyDataSetChanged()
    }

    override fun getItemCount() = personas.size
}