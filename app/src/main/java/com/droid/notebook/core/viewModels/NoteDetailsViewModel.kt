package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService

class NoteDetailsViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    lateinit var title: String
    lateinit var description: String
}