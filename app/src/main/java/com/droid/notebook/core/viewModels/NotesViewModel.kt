package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import com.droid.notebook.utils.navigator.AppNavigator

class NotesViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    lateinit var notes: LiveData<List<Note>>

    init {
        getNotes()
    }

    fun createNoteCommand() {
        appNavigator.navigateToNoteDetailsActivity()
    }

    fun openNoteCommand(note: Note) {
        appNavigator.navigateToNoteDetailsActivity(note)
    }

    private fun getNotes() {
        this.notes = notesService.getNotes().asLiveData()
    }
}