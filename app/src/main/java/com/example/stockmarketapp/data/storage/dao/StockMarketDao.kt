package com.example.stockmarketapp.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.stockmarketapp.data.storage.entity.CompanyListingEntity
import com.example.stockmarketapp.domain.models.CompanyListing
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Vazhapp on 16.08.2022
 */
@Dao
interface StockMarketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompanyListings(
        companyListingEntity: List<CompanyListingEntity>
    )

    @Query("DELETE FROM companylistingentity")
    fun clearCompanyListing()

    @Query(
        """
        SELECT *
        FROM companylistingentity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query) == symbol
    """
    )
    fun searchCompanyListing(query: String): Observable<List<CompanyListing>>
}