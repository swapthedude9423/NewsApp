package com.lastmile.wanicity.data.api

import com.lastmile.wanicity.data.model.News
import com.lastmile.wanicity.data.model.NewsResponse
import com.lastmile.wanicity.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getNews(): Response<NewsResponse>
}