package com.droid.notebook.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.notebook.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
    }
}