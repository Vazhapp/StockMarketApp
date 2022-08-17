package com.example.stockmarketapp.presentation.companyList

/**
 * Created by Vazhapp on 17.08.2022
 */
sealed class CompanyListingEvent {
    object Refresh: CompanyListingEvent()
    data class OnSearchQuery(val query: String): CompanyListingEvent()
}
