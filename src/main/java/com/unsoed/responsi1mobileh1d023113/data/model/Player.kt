package com.unsoed.responsi1mobileh1d023113.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val id: Int?,
    val name: String?,
    val position: String?,
    val nationality: String?,
    val dateOfBirth: String?,
    val shirtNumber: Int?,
    val imageUrl: String? = null
) : Parcelable
