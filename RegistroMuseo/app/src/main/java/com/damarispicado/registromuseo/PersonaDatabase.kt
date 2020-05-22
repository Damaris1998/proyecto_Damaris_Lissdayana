package com.damarispicado.registromuseo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Persona::class), version = 1, exportSchema = false)
abstract class PersonaDatabase : RoomDatabase() {

    abstract fun personaDao(): PersonaDao

    private class PersonaDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var personaDao = database.personaDao()

                    // Delete all content here.
                    personaDao.deleteAll()


                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PersonaDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PersonaDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonaDatabase::class.java,
                    "persona_database"
                )
                    .addCallback(PersonaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
