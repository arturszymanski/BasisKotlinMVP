package com.arturszymanski.presenter

import android.util.Log
import com.arturszymanski.presenter.base.BasePresenter

/**
 * Just for Testing, will be removed or replaced later (TODO).
 */
class TestPresenter : BasePresenter<TestView>() {

    fun doSomething() {
        Log.d("TAG", "Presenter doing something")
        present { it.doSomething() }
    }
}