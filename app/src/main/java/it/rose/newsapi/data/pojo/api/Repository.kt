package it.rose.newsapi.data.pojo.api

import it.rose.newsapi.data.pojo.News
import retrofit2.Response

class Repository {

    suspend fun getNews(): Response<News> {
        return ApiFactory.apiService.getNewsInfo()
    }

}