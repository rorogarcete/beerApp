package com.lastserv.app.beer.domain.interactor.base

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * Default [SingleObserver] base class to define
 */
open class BaseSingleObserver<T> : SingleObserver<T> {

    override fun onSubscribe(disposable: Disposable) { }

    override fun onSuccess(t: T) { }

    override fun onError(exception: Throwable) { }

}