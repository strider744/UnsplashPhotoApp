package com.strider.unsplashphotoviewerapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val description: String?,
    val urls: PhotoUrls,
    val user: PhotoUser
) : Parcelable {
    @Parcelize
    data class PhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String
    ) : Parcelable

    @Parcelize
    data class PhotoUser(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=SimpleImageSearchApp&utm_medium=referral"
    }
}