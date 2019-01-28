package com.arturszymanski.basiskotlinmvp

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.util.Log
import com.arturszymanski.basiskotlinmvp.view.base.BaseActivity
import com.arturszymanski.curriculumvitae.presenter.base.PresenterFactory
import com.arturszymanski.presenter.TestView
import com.arturszymanski.presenter.TestPresenter

class MainActivity : BaseActivity<TestPresenter, TestView>(), TestView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        presenter.doSomething()
    }

    override fun onPresenterPrepared(fromStorage: Boolean) {
    }

    override fun presenterClass(): Class<TestPresenter> {
        return TestPresenter::class.java
    }

    override fun prepareFactory(): PresenterFactory {
        return object : PresenterFactory() {
            override fun <T : ViewModel> createPresenter(presenterClass: Class<T>): T {
                return TestPresenter() as T
            }
        }
    }

    override fun doSomething() {
        Log.d("TAG", "View doing something")
    }
}
