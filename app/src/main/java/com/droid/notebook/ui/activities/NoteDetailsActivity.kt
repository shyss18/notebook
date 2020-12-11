package com.droid.notebook.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.droid.notebook.R
import com.droid.notebook.core.viewModels.NoteDetailsViewModel
import com.droid.notebook.databinding.ActivityNoteDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var noteDetailsViewModel: NoteDetailsViewModel

    private val binding: ActivityNoteDetailsBinding by lazy {
        DataBindingUtil.setContentView<ActivityNoteDetailsBinding>(
            this,
            R.layout.activity_note_details
        )
            .apply {
                lifecycleOwner = this@NoteDetailsActivity
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteDetailsViewModel = ViewModelProvider(this)[NoteDetailsViewModel::class.java]
        binding.viewModel = noteDetailsViewModel
    }
}