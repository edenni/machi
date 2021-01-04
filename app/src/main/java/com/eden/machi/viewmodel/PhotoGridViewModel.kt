package com.eden.machi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eden.machi.network.StreetImageApi
import com.eden.machi.network.StreetImageProperty
import kotlinx.coroutines.launch

enum class StreetImageApiStatus { LOADING, ERROR, DONE}

class PhotoGridViewModel : ViewModel() {
    private val _status = MutableLiveData<StreetImageApiStatus>()
    val status: LiveData<StreetImageApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<StreetImageProperty>>()
    val properties: LiveData<List<StreetImageProperty>>
        get() = _properties


    public fun getImages(lon : Float, lat : Float) {

        viewModelScope.launch {
            _status.value = StreetImageApiStatus.LOADING
            try {
                _properties.value = StreetImageApi.retrofitService.getImages(lon, lat)
                _status.value = StreetImageApiStatus.DONE
            } catch (e: Exception) {
                _status.value = StreetImageApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
}