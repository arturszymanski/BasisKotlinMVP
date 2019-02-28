package com.arturszymanski.presenter.user.details

import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.base.BaseView

interface UserDetailsView : BaseView {
    fun displayUser(user : User)

    fun close()
}