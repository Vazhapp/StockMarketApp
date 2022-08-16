package com.example.stockmarketapp.data.mappers

import com.example.stockmarketapp.data.storage.entity.CompanyListingEntity
import com.example.stockmarketapp.domain.models.CompanyListing

/**
 * Created by Vazhapp on 16.08.2022
 */

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        symbol = symbol,
        name = name,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListing(): CompanyListingEntity {
    return CompanyListingEntity(
        symbol = symbol,
        name = name,
        exchange = exchange
    )
}