package com.eden.machi.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StreetImageProperty(
    val id : Int,
    val lon: Float,
    val lat: Float,
    val img_src: String,
    val filter: String) : Parcelable