package com.example.stockmarketapp.data.network.service

import retrofit2.http.Query

interface StockMarketService {

    fun getListing(
        @Query("apikey") apiKey: String
    )
}