package com.arturszymanski.data.network

import com.arturszymanski.data.model.network.UserDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkData {

    @GET("api/")
    fun getUsers(@Query("results") count: Int) : Single<UserDTO>
}