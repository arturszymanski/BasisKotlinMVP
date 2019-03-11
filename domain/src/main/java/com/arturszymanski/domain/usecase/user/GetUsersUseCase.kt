package com.arturszymanski.domain.usecase.user

import com.arturszymanski.domain.datasource.UserDataSource
import com.arturszymanski.domain.entity.User
import com.arturszymanski.domain.usecase.base.BaseSingleUseCase
import io.reactivex.Single

class GetUsersUseCase(
    val userDataSource: UserDataSource) : BaseSingleUseCase<List<User>>() {

    fun execute(count : Int) : Single<List<User>> {
        return userDataSource.getUsers(count)
            .toList()
            .compose(this::runAsyncReturnOnMain)
    }

}