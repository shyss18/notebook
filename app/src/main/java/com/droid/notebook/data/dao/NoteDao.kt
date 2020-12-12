package com.droid.notebook.data.dao

import androidx.room.*
import com.droid.notebook.data.Note
import com.droid.notebook.utils.constants.Constants.DataBase
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("select * from ${DataBase.noteTable}")
    fun getAllNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateNote(note: Note)

    @Query("delete from ${DataBase.noteTable} where id = :noteId")
    suspend fun deleteNote(noteId: Int)

    @Query("select * from ${DataBase.noteTable} where id = :noteId")
    suspend fun singleNote(noteId: Int): Note
}