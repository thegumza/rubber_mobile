package com.wiwat.template.domain

import com.wiwat.template.data.remote.ApiServices
import okhttp3.ResponseBody


interface BaseRepository {

    suspend fun getSample(): ResponseBody

}

class BaseRepositoryImpl(private val apiServices: ApiServices) : BaseRepository {
    override suspend fun getSample(): ResponseBody {
        return apiServices.getService()
    }
}
