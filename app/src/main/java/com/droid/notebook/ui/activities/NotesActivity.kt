package com.droid.notebook.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.droid.notebook.R
import com.droid.notebook.core.viewModels.NotesViewModel
import com.droid.notebook.databinding.ActivityNotesBinding
import com.droid.notebook.ui.adapters.NotesAdapter
import com.droid.notebook.ui.adapters.listeners.NotesClickListener
import com.droid.notebook.utils.decorations.NotesItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {
    private lateinit var notesViewModel: NotesViewModel

    private val binding: ActivityNotesBinding by lazy {
        DataBindingUtil.setContentView<ActivityNotesBinding>(this, R.layout.activity_notes)
            .apply {
                lifecycleOwner = this@NotesActivity
                viewModel = notesViewModel
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.notesRecyclerViewNotes.layoutManager = gridLayoutManager

        val itemDecoration =
            NotesItemDecoration(resources.getDimensionPixelOffset(R.dimen.notes_offset))
        binding.notesRecyclerViewNotes.addItemDecoration(itemDecoration)

        val notesAdapter = NotesAdapter(NotesClickListener { note ->
            notesViewModel.openNoteCommand(note)
        })

        binding.adapter = notesAdapter

        notesViewModel.notes.observe(this, {
            it?.let(notesAdapter::submitList)
        })
    }
}