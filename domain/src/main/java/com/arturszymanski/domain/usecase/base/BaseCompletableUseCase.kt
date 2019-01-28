package com.arturszymanski.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class for all Completable Usecase's
 */
abstract class BaseCompletableUseCase {

    /**
     * Allow to execute chain on any thread from thread pool and listen it's result on UI thread.
     * @param completable chain to proceed.
     * @return Chain that have set thread to execute and thread to listen for response.
     */
    fun runAsyncReturnOnMain(completable: Completable): Completable {
        return completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
