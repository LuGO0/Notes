package com.example.notes.data

import com.example.commons.models.Note
import com.example.network.NoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NotesRepository @Inject constructor(private val notesService: NoteService) {

    suspend fun saveNote(note: Note) {
        try {
            val response = notesService.saveNote(note)
            if (response.isSuccessful) {
                // The request is successful
                // when you will add the Database in place update its Id
            } else {
                // Handle the error
            }
        } catch (e: Exception) {
            // handle the exception while making network request
        }
    }

    suspend fun getAllNotes(): Flow<List<Note>> {
        try {
            val response: Response<List<Note>> = notesService.getNotes()

            if (response.isSuccessful) {
                // emit flow or something like that
                return flow {
                    response
                }
            } else {
                // handle bad response
            }
        } catch (e: java.lang.Exception) {
            // catch exception
        }

        return emptyFlow()
    }

    suspend fun deleteNote(note: Note) {
        try {
            val response = notesService.deleteNote(note.id)

            if (response.isSuccessful) {
                // deletion successful
            } else {
                // deletion unsuccessful
            }
        } catch (e: Exception) {
            // catch the exception
        }
    }

    suspend fun updateNote(note: Note) {
        try {
            val response = notesService.updateNote(note, note.id)
            if (response.isSuccessful) {
                // updation successful
            } else {
                // updation unsuccessful
            }
        } catch (e: java.lang.Exception) {
            // catch exception
        }
    }
}