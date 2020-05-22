package com.damarispicado.registromuseo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonaViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: PersonaRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allPersona: LiveData<List<Persona>>

    init {
        val personasDao = PersonaDatabase.getDatabase(application, viewModelScope).personaDao()
        repository = PersonaRepository(personasDao)
        allPersona = repository.allPersona
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(persona: Persona) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(persona)
    }
}