package com.eden.machi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.eden.machi.R
import com.eden.machi.network.StreetImageProperty

class PhotoDetailViewModel( streetProperty: StreetImageProperty,
                       app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<StreetImageProperty>()
    val selectedProperty: LiveData<StreetImageProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = streetProperty
    }
}

