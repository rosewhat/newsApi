package it.rose.newsapi.data.pojo.api

import io.reactivex.Single
import it.rose.newsapi.data.pojo.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNewsInfo(
        @Query(QUERY_COUNTRY) country: String = "us",
        @Query(QUERY_CATEGORY) category: String = "science",
        @Query(QUERY_API_KEY) apiKey: String = "ab11d66231874d9dbe225be60f3e1ba4"

    ): Response<News>

    companion object {
        private const val QUERY_API_KEY = "apiKey"
        private const val QUERY_COUNTRY = "country"
        private const val QUERY_CATEGORY = "category"
    }
}