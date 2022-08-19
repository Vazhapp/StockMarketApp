package com.example.stockmarketapp.di.stockMarket

import com.example.stockmarketapp.data.csv.CSVParser
import com.example.stockmarketapp.data.csv.CompanyListingParser
import com.example.stockmarketapp.data.repository.StockMarketRepositoryImpl
import com.example.stockmarketapp.domain.models.CompanyListing
import com.example.stockmarketapp.domain.repository.StockMarketRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Vazhapp on 19.08.2022
 */
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockMarketRepositoryImpl: StockMarketRepositoryImpl
    ): StockMarketRepository
}