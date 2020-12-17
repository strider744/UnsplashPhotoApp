package com.strider.unsplashphotoviewerapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBPhoto(
    @PrimaryKey
    val id: String = "",
    val description: String = "",

    val rawUrl: String = "",
    val regularUrl: String = "",
    val smallUrl: String = "",
    val fullUrl: String = "",
    val author: String = "",
    val attributionUrl: String = "",
    val username: String = ""
)