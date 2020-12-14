package com.droid.notebook.utils.constants

object Constants {
    const val splashTimeOut: Long = 1500
    const val noteId: String = "noteId"
    const val dateFormat: String = "MMM dd, yyyy"

    const val stringIntentType: String = "text/plain"
    const val urlFormat: String = "^(http|https)://"

    object DataBase {
        const val notesDatabase: String = "notes_database"
        const val noteTable: String = "notes_table"
        const val titleColumn: String = "title"
        const val descriptionColumn: String = "description"
        const val dateColumn: String = "date"
    }
}