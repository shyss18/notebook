package com.droid.notebook.core.viewModels

import android.annotation.SuppressLint
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
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

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _date = MutableLiveData<String>()
    val date: LiveData<String>
        get() = _date

    var isEditMode: Boolean = false

    fun initViewModel(noteId: Int) {
        viewModelScope.launch {
            val note = notesService.single(noteId)
            _title.postValue(note.title)
            _description.postValue(note.description)
            _date.postValue(note.date)
        }

        isEditMode = true
    }

    @SuppressLint("SimpleDateFormat")
    fun saveNoteCommand() {
        val currentDate = SimpleDateFormat(Constants.dateFormat).format(Calendar.getInstance().time)

        if (_title.value != null && _description.value != null) {
            val note = Note(_title.value.toString(), _description.value.toString(), currentDate)
            viewModelScope.launch {
                notesService.createNote(note)
            }
        }

        appNavigator.navigateBack()
    }

    fun goBackCommand() {
        appNavigator.navigateBack()
    }
}