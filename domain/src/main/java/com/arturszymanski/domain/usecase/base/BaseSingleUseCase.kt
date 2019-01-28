package com.arturszymanski.domain.usecase.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Base class for all Single Usecase's
 * @param <R> return type of whole chain.
 */
abstract class BaseSingleUseCase<R> {

    /**
     * Allow to execute chain on any thread from thread pool and listen it's result on UI thread.
     * @param single chain to proceed.
     * @return Chain that have set thread to execute and thread to listen for response.
     */
    fun runAsyncReturnOnMain(single: Single<R>): Single<R> {
        return single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
