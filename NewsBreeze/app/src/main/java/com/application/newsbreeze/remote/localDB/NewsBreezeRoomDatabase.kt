package com.application.newsbreeze.remote.localDB

import androidx.room.Database

@Database(entities = [RoomModel::class],version = 1)
abstract class NewsBreezeRoomDatabase {

    abstract fun getResponseFromDao() : NewsBreezeDao

}