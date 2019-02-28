package com.arturszymanski.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
) : Parcelable

@Parcelize
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Parcelable

@Parcelize
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val postcode: String,
    val state: String,
    val street: String,
    val timezone: Timezone
) : Parcelable

@Parcelize
data class Timezone(
    val description: String,
    val offset: String
) : Parcelable

@Parcelize
data class Coordinates(
    val latitude: String,
    val longitude: String
) : Parcelable

@Parcelize
data class Dob(
    val age: Int,
    val date: String
) : Parcelable

@Parcelize
data class Name(
    val first: String,
    val last: String,
    val title: String
) : Parcelable

@Parcelize
data class Id(
    val name: String,
    val value: String
) : Parcelable

@Parcelize
data class Registered(
    val age: Int,
    val date: String
) : Parcelable