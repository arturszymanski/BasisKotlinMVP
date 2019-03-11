package com.arturszymanski.data.model.network

data class LocationDTO(
    val city: String,
    val coordinates: CoordinatesDTO,
    val postcode: String,
    val state: String,
    val street: String,
    val timezone: TimezoneDTO
)