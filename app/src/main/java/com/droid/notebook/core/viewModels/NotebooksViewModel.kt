package com.droid.notebook.core.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note

class NotebooksViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    @Assisted private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

        fun getNotes(): Collection<Note> {
            return notesService.getNotes()
        }
}