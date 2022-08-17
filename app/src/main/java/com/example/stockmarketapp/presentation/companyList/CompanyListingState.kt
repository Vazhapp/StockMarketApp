package com.example.stockmarketapp.presentation.companyList

import com.example.stockmarketapp.domain.models.CompanyListing

/**
 * Created by Vazhapp on 17.08.2022
 */
data class CompanyListingState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
