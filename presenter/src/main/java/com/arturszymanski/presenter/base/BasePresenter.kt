package com.arturszymanski.presenter.base

import android.arch.lifecycle.ViewModel

import java.util.LinkedList
import java.util.Queue

import io.reactivex.disposables.CompositeDisposable

/**
 * Base presenter class that manage flow of any view.
 */
abstract class BasePresenter<V> : ViewModel() where V : BaseView {

    /**
     * View that is used with this presenter.
     */
    var view: V? = null
    /**
     * Internal flag that adds possibility to remember if presenter is bound for first time or presenter restore its state.
     */
    var isFirstBind = true
    /**
     * Queue that keeps all requests to the view, when presenter is unbound.
     */
    var latestViewChanges: Queue<(V) -> Unit> = LinkedList()
    /**
     * Used for RX all disposables added there will be cleared once presenter will not be needed anymore. Allow to avoid
     * memory leaks.
     */
    protected var compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * Invoked if presenter is bound for the first time. Great place to add any data initialization.
     */
    protected open fun onFirstBind() {

    }

    /**
     * Invoked if presenter was previously bound with view.
     */
    protected open fun onViewRestoreState() {}

    /**
     * Function that allow create requests to the view to make any action. Use it as only way to ask view to do something.
     * Never expect that view return something (don't add methods that return any value).
     */
    protected fun present(viewChange: (V) -> Unit) {
        view?.let {
            viewChange.invoke(it)
        } ?: run {
            latestViewChanges.add(viewChange)
        }
    }

    /**
     * Used to bind presenter with view
     * @param view View that implements given interface
     */
    fun bind(view: V) {
        if (this.view != null) {
            throw RuntimeException("Concurrent view bind! Unexpected, second instance of view occurred before " +
                    "first one unbind.")
        }
        this.view = view
        if (isFirstBind) {
            isFirstBind = false
            onFirstBind()
        } else {
            onViewRestoreState()
        }
        while (!latestViewChanges.isEmpty()) {
            present(latestViewChanges.poll())
        }
    }

    /**
     * Used to unbind presenter with view
     */
    fun unbind() {
        this.view = null
    }

    /**
     * Method invoked by ViewModel when it is no longer needed
     */
    override fun onCleared() {
        finish()
        super.onCleared()
    }

    /**
     * Method that allow you to make some actions when presenter will be destroyed. Remember that view might be
     * unavailable in this moment.
     */
    open fun finish() {
        compositeDisposable.dispose()
    }
}
