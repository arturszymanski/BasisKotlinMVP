package com.arturszymanski.domain.datasource

import com.arturszymanski.data.network.NetworkData
import com.arturszymanski.domain.entity.User
import com.arturszymanski.domain.mapper.UserMapper
import io.reactivex.Flowable

class UserDataSourceImpl (
    val networkData: NetworkData,
    val userMapper: UserMapper) : UserDataSource {

    override fun getUsers(count: Int): Flowable<User> {
        return networkData.getUsers(count)
            .map { it.results }
            .toFlowable()
            .flatMapIterable { it }
            .map(userMapper::map)
    }
}