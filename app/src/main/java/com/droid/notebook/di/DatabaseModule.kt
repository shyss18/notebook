package com.droid.notebook.di

import android.content.Context
import androidx.room.Room
import com.droid.notebook.data.dao.NoteDao
import com.droid.notebook.data.database.NoteRoomDatabase
import com.droid.notebook.utils.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideNoteDao(noteRoomDatabase: NoteRoomDatabase): NoteDao {
        return noteRoomDatabase.noteDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): NoteRoomDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            NoteRoomDatabase::class.java,
            Constants.DataBase.notesDatabase
        ).build()
    }
}