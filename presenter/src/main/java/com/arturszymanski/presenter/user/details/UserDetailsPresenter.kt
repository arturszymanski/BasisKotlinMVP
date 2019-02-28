package com.arturszymanski.presenter.user.details

import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.base.BasePresenter

class UserDetailsPresenter : BasePresenter<UserDetailsView>() {

    lateinit var user : User

    override fun onFirstBind() {
        present { it.displayUser(user) }
    }

    override fun onViewRestoreState() {
        present { it.displayUser(user) }
    }

    fun closeSelected() {
        present { it.close() }
    }
}