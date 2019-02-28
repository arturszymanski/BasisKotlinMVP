package com.arturszymanski.basiskotlinmvp.view.user.details

/**
 * Interface that allow to comunicate between User details dialog and it's owner.
 */
interface UserDetailsDialogOwner {

    /**
     * Action called once user closes User Details dialog.
     */
    fun closed()
}