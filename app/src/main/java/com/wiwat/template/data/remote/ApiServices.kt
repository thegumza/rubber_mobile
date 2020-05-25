package com.wiwat.template.data.remote

import okhttp3.ResponseBody

interface ApiServices{
    suspend fun getService() : ResponseBody
}
