package com.arturszymanski.presenter.user

import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.base.BaseView

/**
 * View interface that describes all actions that can be done on view by it's presenter
 */
interface UserListView : BaseView {
    /**
     * Displays list of all user that is passed as parameter.
     * @param userList List of users to display.
     */
    fun displayUserList(userList : List<User>)

    /**
     * Displays user details for give user.
     * @param user User to display details for
     */
    fun displayUserDetails(user : User)
}