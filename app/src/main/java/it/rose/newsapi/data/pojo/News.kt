package it.rose.newsapi.data.pojo

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)