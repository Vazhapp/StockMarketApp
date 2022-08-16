package com.example.stockmarketapp.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vazhapp on 16.08.2022
 */
@Entity
data class CompanyListingEntity(
    @PrimaryKey val id: Int? = null,
    val symbol: String,
    val name: String,
    val exchange: String,
)
