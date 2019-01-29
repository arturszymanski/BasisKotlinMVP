package com.arturszymanski.domain.entity

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
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val postcode: String,
    val state: String,
    val street: String,
    val timezone: Timezone
)

data class Timezone(
    val description: String,
    val offset: String
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Dob(
    val age: Int,
    val date: String
)

data class Name(
    val first: String,
    val last: String,
    val title: String
)

data class Id(
    val name: String,
    val value: String
)

data class Registered(
    val age: Int,
    val date: String
)