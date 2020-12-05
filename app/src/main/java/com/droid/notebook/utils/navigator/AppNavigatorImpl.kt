package com.droid.notebook.utils.navigator

import android.app.Activity
import android.content.Intent
import com.droid.notebook.ui.NotebooksActivity
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val currentActivity: Activity) : AppNavigator {
    override fun navigateToNotebooksActivity() {
        currentActivity.startActivity(
            Intent(
                currentActivity.applicationContext,
                NotebooksActivity::class.java
            )
        )
    }
}