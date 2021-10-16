package com.example.jsonplaceholderrestapi.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geo(
    val lat: Float,
    val lng: Float
) : Parcelable
