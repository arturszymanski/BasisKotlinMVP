package com.arturszymanski.data.model.network

data class ResultDTO(
    val cell: String,
    val dob: DobDTO,
    val email: String,
    val gender: String,
    val id: IdDTO,
    val location: LocationDTO,
    val login: LoginDTO,
    val name: NameDTO,
    val nat: String,
    val phone: String,
    val picture: PictureDTO,
    val registered: RegisteredDTO
)