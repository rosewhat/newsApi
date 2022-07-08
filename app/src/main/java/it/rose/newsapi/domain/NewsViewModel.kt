package it.rose.newsapi.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.rose.newsapi.data.pojo.News
import it.rose.newsapi.data.pojo.api.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel : ViewModel() {

    var repository = Repository()
    val newsModelList: MutableLiveData<Response<News>> = MutableLiveData()

    fun getNewsModel() {
        viewModelScope.launch {
            newsModelList.value = repository.getNews()
        }
    }


}