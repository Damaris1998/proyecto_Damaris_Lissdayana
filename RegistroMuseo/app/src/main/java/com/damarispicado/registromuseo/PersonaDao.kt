package com.damarispicado.registromuseo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonaDao {
    @Query("SELECT * from persona_table ORDER BY nombre ASC")


    fun getAlphabetizedpersonas(): LiveData<List<Persona>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(persona: Persona)

    @Query("DELETE FROM persona_table")
    suspend fun deleteAll()
}