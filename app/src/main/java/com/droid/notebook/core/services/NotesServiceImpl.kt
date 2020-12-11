package com.droid.notebook.core.services

import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import java.util.*
import javax.inject.Inject

class NotesServiceImpl @Inject constructor() : NotesService {
    private val _notes: MutableList<Note> = mutableListOf()

    init {
        for (i in 0..10) {
            _notes.add(Note(i, "Note$i", "Note description $i", Calendar.getInstance().time))
        }
    }

    override fun createNote(note: Note) {
        _notes.add(note)
    }

    override fun getNotes(): List<Note> {
        return _notes
    }

    override fun filter(predicate: (Note) -> Boolean): List<Note> {
        return _notes.filter(predicate)
    }

    override fun single(predicate: (Note) -> Boolean): Note {
        return _notes.single(predicate)
    }
}