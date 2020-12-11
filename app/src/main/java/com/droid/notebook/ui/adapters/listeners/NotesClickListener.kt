package com.droid.notebook.ui.adapters.listeners

import com.droid.notebook.data.Note

class NotesClickListener(val clickListener: (note: Note) -> Unit) {
    fun onClick(note: Note) = clickListener(note)
}