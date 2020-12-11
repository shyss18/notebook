package com.droid.notebook.utils.navigator

import com.droid.notebook.data.Note

interface AppNavigator {
    fun navigateToNotebooksActivity()

    fun navigateToNoteDetailsActivity();

    fun navigateToNoteDetailsActivity(note: Note)

    fun navigateBack();
}