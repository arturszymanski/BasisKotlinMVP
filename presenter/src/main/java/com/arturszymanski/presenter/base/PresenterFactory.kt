package com.arturszymanski.curriculumvitae.presenter.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Wrapper class that allow to add functionality that specifies if presenter was already created or not.
 */
abstract class PresenterFactory : ViewModelProvider.Factory {

    /**
     * Contain information if presenter is just created or restored.
     */
    var isNewCreated = false
        private set

    override fun <T : ViewModel> create(presenterClass: Class<T>): T {
        try {
            val presenter = createPresenter(presenterClass)
            isNewCreated = true
            return presenter
        } catch (throwable: Throwable) {
            throw IllegalArgumentException("Filed to create presenter: ${presenterClass.name}, Exception message: ${throwable.message}")
        }
    }

    /**
     * Function that allow to add presenter creation for presenter owner.
     */
    abstract fun <T : ViewModel> createPresenter(presenterClass: Class<T>): T
}
