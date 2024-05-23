package com.zaroslikov.roomlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "МyFerma")

data class AddTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Title")
    val title: String, // название

    @ColumnInfo(name = "Count")
    val count: Double, // Кол-во
)
