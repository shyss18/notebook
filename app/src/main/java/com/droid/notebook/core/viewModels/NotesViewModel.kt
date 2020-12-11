package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import com.droid.notebook.utils.navigator.AppNavigator

class NotesViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>>
        get() = _notes

    init {
        getNotes()
    }

    fun createNoteCommand() {
        appNavigator.navigateToNoteDetailsActivity()
    }

    private fun getNotes() {
        val notes = notesService.getNotes()
        if (notes.isNotEmpty()) {
            _notes.postValue(notes)
        }
    }
}