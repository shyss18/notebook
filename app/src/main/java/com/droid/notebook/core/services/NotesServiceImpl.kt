package com.droid.notebook.core.services

import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import javax.inject.Inject

class NotesServiceImpl @Inject constructor() : NotesService {
    override fun getNotes(): List<Note> {
        val notes = mutableListOf<Note>()
        for (i in 0..10) {
            notes.add(Note("Note$i", "Note description $i"))
        }

        return notes
    }
}