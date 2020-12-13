package com.droid.notebook.core.viewModels

import android.annotation.SuppressLint
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import com.droid.notebook.utils.constants.Constants
import com.droid.notebook.utils.navigator.AppNavigator
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class NoteDetailsViewModel @ViewModelInject constructor(
    private val notesService: NotesService,
    private val appNavigator: AppNavigator,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val date = MutableLiveData<String>()

    var isEditMode: Boolean = false

    private lateinit var _note: Note

    fun initViewModel(noteId: Int) {
        viewModelScope.launch {
            _note = notesService.single(noteId)

            title.postValue(_note.title)
            description.postValue(_note.description)
            date.postValue(_note.date)
        }

        isEditMode = true
    }

    @SuppressLint("SimpleDateFormat")
    fun saveNoteCommand() {
        val currentDate = SimpleDateFormat(Constants.dateFormat).format(Calendar.getInstance().time)

        if (!title.value.isNullOrEmpty() && !description.value.isNullOrEmpty()) {
            if (isEditMode) {
                _note.title = title.value!!
                _note.description = description.value!!
                _note.date = currentDate
            } else {
                _note = Note(title.value!!, description.value!!, currentDate)
            }

            viewModelScope.launch {
                if (isEditMode) notesService.updateNote(_note) else notesService.createNote(_note)
            }
        }

        appNavigator.navigateBack()
    }

    fun goBackCommand() {
        appNavigator.navigateBack()
    }
}