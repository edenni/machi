package com.eden.machi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eden.machi.network.StreetImageApi
import com.eden.machi.network.StreetImageProperty
import kotlinx.coroutines.launch

enum class StreetImageApiStatus { LOADING, ERROR, DONE }

class PhotoGridViewModel : ViewModel() {
    private val _status = MutableLiveData<StreetImageApiStatus>()
    val status: LiveData<StreetImageApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<StreetImageProperty>>()
    val properties: LiveData<List<StreetImageProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<StreetImageProperty>()
    val navigateToSelectedProperty: LiveData<StreetImageProperty>
        get() = _navigateToSelectedProperty

    init {
        getStreetImageProperties(1.0F,1.0F)
    }

    private fun getStreetImageProperties(lat: Float, lng: Float) {
        viewModelScope.launch {
            _status.value = StreetImageApiStatus.LOADING
            try {
                _properties.value = StreetImageApi.retrofitService.getImages(lat, lng)
                _status.value = StreetImageApiStatus.DONE
            } catch (e: Exception) {
                _status.value = StreetImageApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(streetImageProperty: StreetImageProperty) {
        _navigateToSelectedProperty.value = streetImageProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}