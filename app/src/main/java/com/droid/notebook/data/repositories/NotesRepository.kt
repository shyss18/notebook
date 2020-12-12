package com.droid.notebook.data.repositories

import com.droid.notebook.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    val allNotes: Flow<List<Note>>

    suspend fun insert(note: Note)

    suspend fun update(note: Note)

    suspend fun single(noteId: Int): Note

    suspend fun delete(noteId: Int)
}