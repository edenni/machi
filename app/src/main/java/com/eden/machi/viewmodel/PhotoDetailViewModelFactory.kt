package com.eden.machi.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eden.machi.network.StreetImageProperty

class PhotoDetailViewModelFactory (
        private val streetProperty: StreetImageProperty,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoDetailViewModel::class.java)) {
            return PhotoDetailViewModel(streetProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}