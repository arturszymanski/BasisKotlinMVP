package com.arturszymanski.data.model.network

data class UserDTO(
    val info: InfoDTO,
    val results: List<ResultDTO>
)