package com.lastmile.wanicity.data.api

import com.lastmile.wanicity.data.model.News
import com.lastmile.wanicity.data.model.NewsResponse
import com.lastmile.wanicity.data.model.User
import retrofit2.Response

class ApiHelperImp(private val apiService: ApiService):ApiHelper {

    override suspend fun getNews(): Response<NewsResponse> = apiService.getNews()
}