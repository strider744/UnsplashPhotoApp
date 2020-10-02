package com.strider.imagesearchapp.api

import com.strider.imagesearchapp.data.Photo

data class ServerResponse(
    val results: List<Photo>
) {
}