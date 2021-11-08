package com.application.newsbreeze.remote.localDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsBreeze_db")
data class RoomModel(
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null
}