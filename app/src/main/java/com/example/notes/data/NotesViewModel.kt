package com.example.notes.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.commons.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {

    // Here we will expose state and observe it thorough the UI
    val notes: MutableLiveData<List<Note>> = MutableLiveData()


    // The notesLiveData is initialized with initial list of Notes
    init {
        runBlocking {

            // child scope
            val result = withContext(Dispatchers.IO) {
                repository.getAllNotes()
            }

            notes.value = result
        }
    }

    fun updateNotes() {
        runBlocking {
            notes.value = repository.getAllNotes()
        }
    }

    override fun onCleared() {
        super.onCleared()

        // I think you dont need to do this anymore
        // since you were not creating a coroutineScope yourself!
        // viewModelScope.cancel()
    }
}