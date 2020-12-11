package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import com.droid.notebook.utils.navigator.AppNavigator

class NoteDetailsViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var title: String = ""
    var description: String = ""
    var date: String = ""
    var isEditMode: Boolean = false

    fun initViewModel(noteId: Int) {
        val note = notesService.single { it.id == noteId }
        if (note != null) {
            title = note.title
            description = note.description
            date = note.date
            isEditMode = true
        } else {
            isEditMode = false
        }
    }

    fun saveNoteCommand() {
        val note = Note(11, this.title, this.description, this.date)
        notesService.createNote(note)
    }

    fun goBackCommand() {
        appNavigator.navigateBack()
    }
}