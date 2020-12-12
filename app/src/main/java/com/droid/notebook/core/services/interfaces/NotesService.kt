package com.droid.notebook.core.services.interfaces

import com.droid.notebook.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesService {
    suspend fun createNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(noteId: Int)

    fun getNotes(): Flow<List<Note>>

    fun filter(predicate: (Note) -> Boolean): List<Note>

    suspend fun single(noteId: Int): Note
}