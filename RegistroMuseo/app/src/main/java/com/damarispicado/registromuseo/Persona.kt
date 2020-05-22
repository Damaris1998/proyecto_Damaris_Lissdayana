package com.damarispicado.registromuseo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "persona_table")


data class Persona(
    @PrimaryKey(autoGenerate= true)
    var id: Int= 0,
    @ColumnInfo(name="nombre") var nombre: String,
    @ColumnInfo(name="apellido") var apellido: String,
    @ColumnInfo(name="sexo") var sexo: String,
    @ColumnInfo(name="etnia") var etnia: String,
    @ColumnInfo(name="identificacion") var identificacion: String,
    @ColumnInfo(name="direccion") var direccion: String

)


{
}