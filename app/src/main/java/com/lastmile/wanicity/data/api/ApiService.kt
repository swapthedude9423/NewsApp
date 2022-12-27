package com.lastmile.wanicity.data.api

import com.lastmile.wanicity.BuildConfig
import com.lastmile.wanicity.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v2/top-headlines?country=in&apiKey="+BuildConfig.API)
    suspend fun getNews(): Response<NewsResponse>
}