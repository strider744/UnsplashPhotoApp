package com.strider.unsplashphotoviewerapp.database.dao

import androidx.room.*
import com.strider.unsplashphotoviewerapp.database.entity.DBPhoto

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: DBPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(list: List<DBPhoto>)

    @Query("SELECT * FROM DBPhoto WHERE id = :id")
    suspend fun getPhoto(id: String): DBPhoto

    @Query("SELECT * FROM DBPhoto WHERE id IN (:list)")
    suspend fun getPhoto(list: List<String>): DBPhoto
}