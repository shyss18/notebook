package com.droid.notebook.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.droid.notebook.utils.constants.Constants.DataBase

@Entity(tableName = DataBase.noteTable)
data class Note(
    @ColumnInfo(name = DataBase.titleColumn) var title: String,
    @ColumnInfo(name = DataBase.descriptionColumn) var description: String,
    @ColumnInfo(name = DataBase.dateColumn) var date: String
) {
    @PrimaryKey(
        autoGenerate = true
    )
    var id: Int = 0
}