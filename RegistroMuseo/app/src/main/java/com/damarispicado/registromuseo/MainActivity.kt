package com.damarispicado.registromuseo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_new__persona.*

class MainActivity : AppCompatActivity() {



    private lateinit var personaViewModel: PersonaViewModel
    private val newPersonaActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PersonaListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        personaViewModel = ViewModelProvider(this).get(PersonaViewModel::class.java)
        personaViewModel.allPersona.observe(this, Observer { personas ->
            // Update the cached copy of the words in the adapter.
            personas?.let { adapter.setPersonas(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, New_Persona::class.java)
            startActivityForResult(intent, newPersonaActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newPersonaActivityRequestCode && resultCode == Activity.RESULT_OK) {

            var nombre = ""
            var apellido = ""
            var sexo = ""
            var etnia = ""
            var identificacion = ""
            var direccion = ""

            data?.getStringExtra("Nombre")?.let {
                nombre = it
            }
            data?.getStringExtra("Apellido")?.let {
                apellido = it
            }
            data?.getStringExtra("Sexo")?.let {
                sexo = it
            }
            data?.getStringExtra("Etnia")?.let {
                etnia = it
            }
            data?.getStringExtra("Identificacion")?.let {
                identificacion = it
            }
            data?.getStringExtra("Direccion")?.let {
                direccion = it
            }
            //Log.d("datos", tipo)
            //Log.d("datos", monto)

            var persona =
                Persona(id = 0, nombre= nombre, apellido = apellido, sexo = sexo, etnia = etnia,identificacion = identificacion,direccion = direccion)
            personaViewModel.insert(persona)


        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}



