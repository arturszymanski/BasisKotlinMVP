package com.arturszymanski.domain.datasource

import com.arturszymanski.domain.entity.User
import io.reactivex.Flowable

interface UserDataSource {
    fun getUsers(count : Int) : Flowable<User>
}