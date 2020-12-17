package com.strider.unsplashphotoviewerapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.strider.unsplashphotoviewerapp.api.PhotoApi
import com.strider.unsplashphotoviewerapp.database.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(private val api: PhotoApi, private val database: AppDatabase) {

    fun getSearchResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ApiPagingSource(api, query, database) }
        ).liveData
}