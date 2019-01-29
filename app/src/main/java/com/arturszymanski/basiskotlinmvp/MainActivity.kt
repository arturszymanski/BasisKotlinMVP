package com.arturszymanski.basiskotlinmvp

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.arturszymanski.basiskotlinmvp.view.base.BasePresenterActivity
import com.arturszymanski.basiskotlinmvp.view.user.list.UserListFragment
import com.arturszymanski.curriculumvitae.presenter.base.PresenterFactory
import com.arturszymanski.presenter.TestView
import com.arturszymanski.presenter.TestPresenter

class MainActivity : BasePresenterActivity<TestPresenter, TestView>(), TestView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            var userListFragment : UserListFragment = UserListFragment.newInstance()

            supportFragmentManager.beginTransaction()
                    .add(R.id.container, userListFragment)
                    .commit()
        }
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
}
