package com.arturszymanski.domain.usecase.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class for all Observable Usecase's
 * @param <R> return type of whole chain.
 */
abstract class BaseObservableUseCase<R> {

    /**
     * Allow to execute chain on any thread from thread pool and listen it's result on UI thread.
     * @param observable chain to proceed.
     * @return Chain that have set thread to execute and thread to listen for response.
     */
    fun runAsyncReturnOnMain(observable: Observable<R>): Observable<R> {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
