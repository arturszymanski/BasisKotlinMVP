package com.arturszymanski.domain.mapper

import com.arturszymanski.data.model.network.ResultDTO
import com.arturszymanski.domain.entity.*
import java.text.SimpleDateFormat

class UserMapper(val simpleDateFormat: SimpleDateFormat) {
    fun map(resultDTO: ResultDTO) : User {
        return User(cell = resultDTO.cell,
            email = resultDTO.email,
            registered = simpleDateFormat.parse(resultDTO.registered.date),
            picture = resultDTO.picture.large,
            phone = resultDTO.phone,
            nat = resultDTO.nat,
            gender = resultDTO.gender,
            dob = simpleDateFormat.parse(resultDTO.dob.date),
            id = resultDTO.id.value,
            name = Name(
                first = resultDTO.name.first,
                last = resultDTO.name.last,
                title = resultDTO.name.title),
            location = Location(
                city = resultDTO.location.city,
                street = resultDTO.location.street,
                state = resultDTO.location.state,
                postcode = resultDTO.location.postcode,
                timezone = Timezone(
                    description = resultDTO.location.timezone.description,
                    offset = resultDTO.location.timezone.offset),
                coordinates = Coordinates(
                    longitude = resultDTO.location.coordinates.longitude,
                    latitude = resultDTO.location.coordinates.latitude))
        )
    }
}