package com.eidorian.rawgapigames.domain.usecases

import android.annotation.SuppressLint
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseUSeCase {
    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun <T> makeCall(
        call: () -> Single<T>,
        callback: UseCaseCallback<T>
    ) {
        call()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .subscribe({ t ->
                callback.onSuccess(t)
            }, {
                callback.onError(it)
            })
    }

    interface UseCaseCallback<T> {
        fun onSuccess(data: T)
        fun onError(t: Throwable)
    }
}