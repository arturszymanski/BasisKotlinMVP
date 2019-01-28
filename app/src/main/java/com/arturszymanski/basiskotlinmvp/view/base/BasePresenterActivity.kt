package com.arturszymanski.basiskotlinmvp.view.base

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arturszymanski.curriculumvitae.presenter.base.PresenterFactory
import com.arturszymanski.presenter.base.BaseView
import com.arturszymanski.presenter.base.BasePresenter

/**
 * Base Activity that adds support for presenter and allow to keep state of this presenter. Also handles basis
 * presenter methods and needs.
 */
abstract class BasePresenterActivity<P, V> : AppCompatActivity() where V : BaseView, P : BasePresenter<V> {

    /**
     * Instance of presenter.
     */
    lateinit var presenter : P
    /**
     * Instance of presenter factory that allow to create presenter and check if was previously created.
     */
    private lateinit var presenterFactory : PresenterFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterFactory = prepareFactory()

        presenter = ViewModelProviders.of(this, presenterFactory).get(presenterClass())
        onPresenterPrepared(fromStorage = !presenterFactory.isNewCreated)
    }

    override fun onStart() {
        super.onStart()

        if(::presenter.isInitialized) {
            presenter.bind(this as V)
        }
    }

    override fun onStop() {
        if(::presenter.isInitialized) {
            presenter.unbind()
        }

        super.onStop()
    }

    /**
     * Invoked when presenter was prepared and ready for use in this view. Might be used to setup initial presenter
     * parameters, eg. from Bundle
     * @param fromStorage inform if presenter was created (fromStorage = false) or restored (fromStorage = true)
     */
    abstract fun onPresenterPrepared(fromStorage: Boolean)

    /**
     * Method needed to create instance of presenter.
     * @return Return class of presenter used by this view. eg. BasePresenter::class.java
     */
    abstract fun presenterClass(): Class<P>

    /**
     * Method that create presenter factory that will be used to create presenter.
     * @return PresenterFactory that will be used to create presenter.
     */
    abstract fun prepareFactory() : PresenterFactory
}