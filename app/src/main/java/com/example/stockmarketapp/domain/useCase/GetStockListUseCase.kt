package com.example.stockmarketapp.domain.useCase

import com.example.stockmarketapp.data.csv.CompanyListingParser
import com.example.stockmarketapp.domain.models.CompanyListing
import com.example.stockmarketapp.domain.repository.StockMarketRepository
import com.example.stockmarketapp.util.ObservableUseCase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Created by Vazhapp on 17.08.2022
 */
class GetStockListUseCase @Inject constructor(
    private val stockMarketRepository: StockMarketRepository,
    private val companyListingParser: CompanyListingParser
) : ObservableUseCase<List<CompanyListing>, String>() {
    override fun buildUseCaseObservable(params: String?): Observable<List<CompanyListing>> {
        return stockMarketRepository.getCompanyListings(
            query = params!!,
            fetchFromRemote = false
        ).map {
            companyListingParser.parse(it.byteStream())
        }
    }
}