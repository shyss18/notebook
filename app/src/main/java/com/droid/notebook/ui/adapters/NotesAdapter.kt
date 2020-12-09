package com.droid.notebook.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.droid.notebook.data.Note
import com.droid.notebook.databinding.ItemNoteBinding
import com.droid.notebook.ui.adapters.viewHolders.NoteViewHolder

class NotesAdapter : ListAdapter<Note, NoteViewHolder> (Companion) {
    companion object: DiffUtil.ItemCallback<Note> () {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(layoutInflater)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.note = currentItem
        holder.binding.executePendingBindings()
    }
}