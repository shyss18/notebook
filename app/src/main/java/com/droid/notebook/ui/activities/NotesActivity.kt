package com.droid.notebook.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.droid.notebook.R
import com.droid.notebook.core.viewModels.NotebooksViewModel
import com.droid.notebook.databinding.ActivityNotebooksBinding
import com.droid.notebook.ui.adapters.NotesAdapter
import com.droid.notebook.utils.decorations.NotesItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {
    private lateinit var notebooksViewModel: NotebooksViewModel

    private val binding: ActivityNotebooksBinding by lazy {
        DataBindingUtil.setContentView<ActivityNotebooksBinding>(this, R.layout.activity_notebooks)
            .apply {
                lifecycleOwner = this@NotesActivity
                viewModel = notebooksViewModel
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notebooksViewModel = ViewModelProvider(this)[NotebooksViewModel::class.java]

        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.notebooksRecyclerViewNotes.layoutManager = gridLayoutManager

        val itemDecoration = NotesItemDecoration(resources.getDimensionPixelOffset(R.dimen.notes_offset))
        binding.notebooksRecyclerViewNotes.addItemDecoration(itemDecoration)

        val notesAdapter = NotesAdapter()
        binding.adapter = notesAdapter

        notebooksViewModel.notes.observe(this, {
            it.let(notesAdapter::submitList)
        })
    }
}