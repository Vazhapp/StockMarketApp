package com.example.stockmarketapp.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stockmarketapp.data.storage.dao.StockMarketDao
import com.example.stockmarketapp.data.storage.entity.CompanyListingEntity

/**
 * Created by Vazhapp on 16.08.2022
 */
@Database(entities = [CompanyListingEntity::class], version = 1)
abstract class StockMarketDatabase : RoomDatabase() {

    abstract fun getStockMarketDao(): StockMarketDao

}