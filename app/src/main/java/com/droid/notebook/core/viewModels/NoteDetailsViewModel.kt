package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.utils.navigator.AppNavigator

class NoteDetailsViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var title: String = ""
    var description: String = ""

    fun saveNoteCommand() {

    }

    fun goBackCommand() {
        appNavigator.navigateBack()
    }
}