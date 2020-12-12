package com.droid.notebook.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.droid.notebook.data.Note
import com.droid.notebook.data.dao.NoteDao

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}