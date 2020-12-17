package com.strider.unsplashphotoviewerapp.data

import androidx.paging.PagingSource
import com.strider.unsplashphotoviewerapp.api.PhotoApi
import com.strider.unsplashphotoviewerapp.database.AppDatabase
import com.strider.unsplashphotoviewerapp.database.entity.DBPhoto
import retrofit2.HttpException
import java.io.IOException

class ApiPagingSource(
    private val api: PhotoApi,
    private val query: String,
    private val database: AppDatabase
) : PagingSource<Int, Photo>() {

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }

    // todo подгрузка из бызы
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = api.searchPhoto(query, position, params.loadSize)
            val photos = response.results
            database.photoDao().insertPhoto(mapToEntity(photos))

            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    private fun mapToEntity(list: List<Photo>): List<DBPhoto> {
        return list.map {
            DBPhoto(
                id = it.id,
                description = it.description ?: "",
                rawUrl = it.urls.raw,
                regularUrl = it.urls.regular,
                smallUrl = it.urls.small,
                fullUrl = it.urls.full,
                author = it.user.name,
                username = it.user.username,
                attributionUrl = it.user.attributionUrl
            )
        }
    }

    private fun mapFromEntity(list: List<DBPhoto>): List<Photo> {
        return list.map {
            Photo(
                id = it.id,
                description = it.description,
                urls = Photo.PhotoUrls(
                    raw = it.rawUrl,
                    full = it.fullUrl,
                    regular = it.regularUrl,
                    small = it.smallUrl
                ),
                user = Photo.PhotoUser(
                    name = it.author,
                    username = it.username
                )
            )
        }
    }
}