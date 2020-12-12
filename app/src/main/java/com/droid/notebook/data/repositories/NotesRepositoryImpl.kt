package com.droid.notebook.data.repositories

import com.droid.notebook.data.Note
import com.droid.notebook.data.dao.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NotesRepository {
    override val allNotes: Flow<List<Note>>
        get() = noteDao.getAllNotes()

    override suspend fun insert(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun update(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun single(noteId: Int): Note {
        return noteDao.singleNote(noteId)
    }

    override suspend fun delete(noteId: Int) {
        noteDao.deleteNote(noteId)
    }
}