package com.damarispicado.registromuseo

import androidx.lifecycle.LiveData


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class PersonaRepository(private val personaDao: PersonaDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allPersona: LiveData<List<Persona>> = personaDao.getAlphabetizedpersonas()

    suspend fun insert(persona: Persona) {
        personaDao.insert(persona)
    }
}