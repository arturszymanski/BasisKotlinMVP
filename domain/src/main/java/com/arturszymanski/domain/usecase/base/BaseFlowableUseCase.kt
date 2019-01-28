package com.arturszymanski.domain.usecase.base

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class for all Flowable Usecase's
 * @param <R> return type of whole chain.
 */
abstract class BaseFlowableUseCase<R> {

    /**
     * Allow to execute chain on any thread from thread pool and listen it's result on UI thread.
     * @param flowable chain to proceed.
     * @return Chain that have set thread to execute and thread to listen for response.
     */
    fun runAsyncReturnOnMain(flowable: Flowable<R>): Flowable<R> {
        return flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
