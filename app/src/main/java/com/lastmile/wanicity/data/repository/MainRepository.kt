package com.lastmile.wanicity.data.repository

import com.lastmile.wanicity.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getNews() = apiHelper.getNews()
}