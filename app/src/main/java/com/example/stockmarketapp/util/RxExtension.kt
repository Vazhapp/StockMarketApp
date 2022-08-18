package com.example.stockmarketapp.util

import io.reactivex.rxjava3.core.Observable

/**
 * Created by Vazhapp on 18.08.2022
 */

fun <T : Any> T.makeObservable():
        Observable<T> = Observable.just<T>(this)
