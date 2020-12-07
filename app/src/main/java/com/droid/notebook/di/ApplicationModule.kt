package com.droid.notebook.di

import com.droid.notebook.core.services.NotesServiceImpl
import com.droid.notebook.core.services.interfaces.NotesService
import com.droid.notebook.utils.navigator.AppNavigator
import com.droid.notebook.utils.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator

    @Binds
    abstract fun bindNotesService(impl: NotesServiceImpl) : NotesService
}