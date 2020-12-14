package com.droid.notebook.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.droid.notebook.R
import com.droid.notebook.core.viewModels.NoteDetailsViewModel
import com.droid.notebook.databinding.ActivityNoteDetailsBinding
import com.droid.notebook.utils.constants.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var noteDetailsViewModel: NoteDetailsViewModel

    private val binding: ActivityNoteDetailsBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_note_details
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteDetailsViewModel = ViewModelProvider(this)[NoteDetailsViewModel::class.java]
        binding.viewModel = noteDetailsViewModel
        binding.lifecycleOwner = this

        if (intent?.action == Intent.ACTION_SEND) {
            if (Constants.stringIntentType == intent.type) {
                noteDetailsViewModel.initViewModel(intent.getStringExtra(Intent.EXTRA_TEXT)!!)
            }
        } else {
            val hash = intent.getIntExtra(Constants.noteId, -1)
            if (hash != -1) {
                noteDetailsViewModel.initViewModel(hash)
            }
        }
    }
}