package com.droid.notebook.core.services.interfaces

import com.droid.notebook.data.Note

interface NotesService {
    fun createNote(note: Note)

    fun getNotes(): List<Note>

    fun filter(predicate: (Note) -> Boolean): List<Note>

    fun single(predicate: (Note) -> Boolean): Note
}