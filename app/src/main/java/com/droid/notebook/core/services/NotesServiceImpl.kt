package com.droid.notebook.core.services

import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.data.Note
import com.droid.notebook.data.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesServiceImpl @Inject constructor(private val notesRepository: NotesRepository) :
    NotesService {
    override suspend fun createNote(note: Note) {
        notesRepository.insert(note)
    }

    override suspend fun updateNote(note: Note) {
        notesRepository.update(note)
    }

    override suspend fun deleteNote(noteId: Int) {
        notesRepository.delete(noteId)
    }

    override fun getNotes(): Flow<List<Note>> {
        return notesRepository.allNotes
    }

    override fun filter(predicate: (Note) -> Boolean): List<Note> {
        TODO()
    }

    override suspend fun single(noteId: Int): Note {
        return notesRepository.single(noteId)
    }
}