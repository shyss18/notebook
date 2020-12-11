package com.droid.notebook.core.viewModels

import android.annotation.SuppressLint
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.utils.constants.Constants
import com.droid.notebook.utils.navigator.AppNavigator
import java.text.SimpleDateFormat

class NoteDetailsViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var title: String = ""
    var description: String = ""
    var date: String = ""
    var isEditMode: Boolean = false

    @SuppressLint("SimpleDateFormat")
    fun initViewModel(noteId: Int) {
        val note = notesService.single { it.id == noteId }
        if (note != null) {
            title = note.title
            description = note.description
            date = SimpleDateFormat(Constants.dateFormat).format(note.date)
            isEditMode = true
        } else {
            isEditMode = false
        }
    }

    fun saveNoteCommand() {

    }

    fun goBackCommand() {
        appNavigator.navigateBack()
    }
}