package com.arturszymanski.domain.usecase.base

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class for all Maybe Usecase's
 * @param <R> return type of whole chain.
 */
abstract class BaseMaybeUseCase<R> {

    /**
     * Allow to execute chain on any thread from thread pool and listen it's result on UI thread.
     * @param maybe chain to proceed.
     * @return Chain that have set thread to execute and thread to listen for response.
     */
    fun runAsyncReturnOnMain(maybe: Maybe<R>): Maybe<R> {
        return maybe
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
