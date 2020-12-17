package com.strider.unsplashphotoviewerapp.api

import com.strider.unsplashphotoviewerapp.data.Photo

data class SearchPhotoResponse(
    val results: List<Photo>
)