package com.strider.unsplashphotoviewerapp.api

import com.strider.unsplashphotoviewerapp.data.Photo

data class ServerResponse(
    val results: List<Photo>
) {
}