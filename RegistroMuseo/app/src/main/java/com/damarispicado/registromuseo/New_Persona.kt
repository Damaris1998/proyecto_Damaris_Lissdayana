package com.damarispicado.registromuseo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText

class New_Persona : AppCompatActivity() {

    private lateinit var editNombreView: EditText
    private lateinit var editApellidoView: EditText
    private lateinit var editSexoView: EditText
    private lateinit var editEtniaView: EditText
    private lateinit var editIdetificacionView: EditText
    private lateinit var editDireccionView: EditText


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new__persona)
        editNombreView= findViewById(R.id.editnombre)
        editApellidoView= findViewById(R.id.editapellido)
        editSexoView= findViewById(R.id.editsexo)
        editEtniaView= findViewById(R.id.editetnia)
        editIdetificacionView= findViewById(R.id.editidentificacion)
        editDireccionView= findViewById(R.id.editdireccion)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editNombreView.text )) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nombre = editNombreView.text.toString()
                val apellido = editApellidoView.text.toString()
                val sexo= editSexoView.text.toString()
                val etnia= editEtniaView.text.toString()
                val identificacion=editIdetificacionView.text.toString()
                val direccion=editDireccionView.text.toString()

                Log.d("dato",nombre)
                Log.d("dato",apellido)
                Log.d("dato",sexo)
                Log.d("dato",etnia)
                Log.d("dato",identificacion)
                Log.d("dato",direccion)


                replyIntent.putExtra("Nombre", nombre)
                replyIntent.putExtra("Apellido", apellido)
                replyIntent.putExtra("Sexo", sexo)
                replyIntent.putExtra("Etnia", etnia)
                replyIntent.putExtra("Identificacion", identificacion)
                replyIntent.putExtra("Direccion", direccion)

                setResult(Activity.RESULT_OK, replyIntent)



            }



            finish()
        }
    }


    }


