package it.rose.newsapi.data.pojo.api

import it.rose.newsapi.data.pojo.News
import retrofit2.Response

class Repository {

    fun getNews(): Response<News> {
        return ApiFactory.apiService.getNewsInfo("us", "science", "ab11d66231874d9dbe225be60f3e1ba4");
    }

}