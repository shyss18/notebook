package com.droid.notebook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.droid.notebook.R
import com.droid.notebook.core.viewModels.NotebooksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotebooksActivity : AppCompatActivity() {
    private lateinit var notebooksViewModel: NotebooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebooks)

        notebooksViewModel = ViewModelProvider(this)[NotebooksViewModel::class.java]
    }
}