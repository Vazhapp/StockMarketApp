package com.example.stockmarketapp.domain.repository

import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody

/**
 * Created by Vazhapp on 16.08.2022
 */
interface StockMarketRepository {

    fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Observable<ResponseBody>
}