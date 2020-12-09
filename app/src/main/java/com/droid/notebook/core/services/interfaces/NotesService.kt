package com.droid.notebook.core.services.interfaces

import com.droid.notebook.data.Note

interface NotesService {
    fun getNotes(): List<Note>
}