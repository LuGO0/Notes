package com.example.notes.data

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.*
import com.example.commons.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotesViewModel @Inject constructor(val repository: NotesRepository) : ViewModel() {

    // Here we will expose state and observe it thorough the UI
    val notes:MutableLiveData<List<Note>> = MutableLiveData()


    // The notesLiveData is initialized correctly
    init {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.getAllNotes()
            }

            notes.value = result.asLiveData(viewModelScope.coroutineContext).value
        }
    }

    // now what how do I periodically  fetch it and display it??

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}