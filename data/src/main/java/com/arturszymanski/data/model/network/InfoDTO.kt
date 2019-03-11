package com.arturszymanski.data.model.network

data class InfoDTO(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)