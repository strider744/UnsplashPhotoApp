package com.strider.unsplashphotoviewerapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.strider.unsplashphotoviewerapp.database.dao.PhotoDao
import com.strider.unsplashphotoviewerapp.database.entity.DBPhoto

@Database(
    entities = [
        DBPhoto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}