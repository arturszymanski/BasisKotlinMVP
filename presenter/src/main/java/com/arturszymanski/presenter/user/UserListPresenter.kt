package com.arturszymanski.presenter.user

import com.arturszymanski.domain.entity.User
import com.arturszymanski.domain.usecase.user.GetUsersUseCase
import com.arturszymanski.presenter.base.BasePresenter

/**
 * Presenter that provide functionalities and data for User List view
 */
class UserListPresenter(
        val getUsersUseCase: GetUsersUseCase) : BasePresenter<UserListView>() {

    /**
     * List of users which will be displayed
     */
    var userList : List<User> = ArrayList()

    override fun onFirstBind() {
        fetchUsers()
    }

    override fun onViewRestoreState() {
        present { view -> view.displayUserList(userList) }
    }

    //region UI
    /**
     * Method called by view once any user was selected.
     * @param position Position of selected user
     */
    fun itemSelected(position: Int) {
        var selectedUser = userList[position]
        present { it.displayUserDetails(user = selectedUser) }
    }
    //endregion UI

    //region fetch users
    fun fetchUsers() {
        compositeDisposable.add(
            getUsersUseCase.execute(20)
                .subscribe(
                    this::fetchUsersSuccess,
                    this::fetchUsersFiled))
    }

    fun fetchUsersSuccess(userList: List<User>) {
        this.userList = userList
        present { view -> view.displayUserList(userList) }
    }

    fun fetchUsersFiled(throwable: Throwable) {
        //TODO change once logging lib will be added
        throwable.printStackTrace()
    }
    //endregion
}