package com.example.stockmarketapp.util

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Vazhapp on 17.08.2022
 */
abstract class ObservableUseCase<T: Any, in Params> {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    /**
     * Executes current useCase
     */
    open fun execute(params: Params? = null): Observable<T> {
        return buildUseCaseObservable(params)
            .subscribeOn(getScheduler())
            .observeOn(AndroidSchedulers.mainThread())
    }

    protected open fun getScheduler() = Schedulers.io()
}