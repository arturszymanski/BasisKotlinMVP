package com.arturszymanski.basiskotlinmvp.view.user.list

/**
 * Interface that describes all actions that can be done on User List like clicks, swipe etc.
 */
interface UserListItemInteractions {

    /**
     * Action that inform that whole item was selected (clicked) at given position.
     * @param position selected item position. Should be exactly the sam as position in UserList passed to adapter.
     */
    fun itemSelected(position : Int)
}