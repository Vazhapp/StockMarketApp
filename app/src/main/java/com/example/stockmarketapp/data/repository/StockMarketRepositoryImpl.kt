package com.example.stockmarketapp.data.repository

import com.example.stockmarketapp.data.network.service.StockMarketService
import com.example.stockmarketapp.data.storage.StockMarketDatabase
import com.example.stockmarketapp.domain.models.CompanyListing
import com.example.stockmarketapp.domain.repository.StockMarketRepository
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * Created by Vazhapp on 16.08.2022
 */
class StockMarketRepositoryImpl @Inject constructor(
    private val stockMarketService: StockMarketService,
    val stockMarketDb: StockMarketDatabase,
) : StockMarketRepository {

    override fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Observable<ResponseBody> {
        return stockMarketService.getListing()
    }
}