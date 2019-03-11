package com.arturszymanski.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(
    val cell: String,
    val dob: Date,
    val email: String,
    val gender: String,
    val id: String?,
    val location: Location,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: String,
    val registered: Date
) : Parcelable

