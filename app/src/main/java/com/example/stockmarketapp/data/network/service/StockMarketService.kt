package com.example.stockmarketapp.data.network.service

import com.example.stockmarketapp.BuildConfig
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockMarketService {

    @GET("query?function=LISTING_STATUS")
    fun getListing(
        @Query("apikey") apiKey: String = BuildConfig.STOCK_MARKET_API_KEY
    ): Observable<ResponseBody>
}