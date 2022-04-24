package com.example.notes.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commons.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View models should not contain context obviously, but
 */
@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {

    // Here we will expose state and observe it thorough the UI
    val notes: MutableLiveData<List<Note>> = MutableLiveData(emptyList())
    val isRefreshing = MutableLiveData(false)

    // The notesLiveData is initialized with initial list of Notes
    init {
        refresh()
    }

    fun refresh() {
        // This doesn't handle multiple 'refreshing' tasks, don't use this
        viewModelScope.launch(Dispatchers.IO) {
            isRefreshing.postValue(true)
            notes.postValue(repository.getAllNotes())
            isRefreshing.postValue(false)
        }
    }

    override fun onCleared() {
        super.onCleared()

        // I think you dont need to do this anymore
        // since you were not creating a coroutineScope yourself!
        // viewModelScope.cancel()
    }
}