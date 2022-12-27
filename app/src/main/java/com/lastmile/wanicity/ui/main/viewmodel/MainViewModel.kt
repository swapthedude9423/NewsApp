package com.lastmile.wanicity.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastmile.wanicity.data.model.News
import com.lastmile.wanicity.data.model.NewsResponse
import com.lastmile.wanicity.data.repository.MainRepository
import com.lastmile.wanicity.utils.NetworkHelper
import com.lastmile.wanicity.utils.Resource
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
):ViewModel() {


    private val _news =  MutableLiveData<Resource<NewsResponse>>();
    val news : LiveData<Resource<NewsResponse>> get() = _news

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _news.postValue(Resource.loading(null))
            if(networkHelper.isNetworkConnected()){
                mainRepository.getNews().let {
                    if(it.isSuccessful){
                        _news.postValue(Resource.success(it.body()))
                    }else
                        _news.postValue(Resource.failed(it.errorBody().toString(),null))
                }
            }else
                _news.postValue(Resource.failed("No internet connection",null))
        }
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared: ")
        super.onCleared()
    }

}