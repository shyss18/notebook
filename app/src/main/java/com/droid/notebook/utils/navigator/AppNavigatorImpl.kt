package com.droid.notebook.utils.navigator

import android.app.Activity
import android.content.Intent
import com.droid.notebook.data.Note
import com.droid.notebook.ui.activities.NoteDetailsActivity
import com.droid.notebook.ui.activities.NotesActivity
import com.droid.notebook.utils.constants.Constants
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val currentActivity: Activity) : AppNavigator {
    override fun navigateToNotebooksActivity() {
        currentActivity.startActivity(
            Intent(
                currentActivity.applicationContext,
                NotesActivity::class.java
            )
        )
    }

    override fun navigateToNoteDetailsActivity() {
        currentActivity.startActivity(
            Intent(
                currentActivity.applicationContext,
                NoteDetailsActivity::class.java
            )
        )
    }

    override fun navigateToNoteDetailsActivity(note: Note) {
        val intent = Intent(
            currentActivity.applicationContext,
            NoteDetailsActivity::class.java
        )

        intent.putExtra(Constants.noteId, note.id)
        currentActivity.startActivity(intent)
    }

    override fun navigateBack() {
        currentActivity.finish()
    }
}