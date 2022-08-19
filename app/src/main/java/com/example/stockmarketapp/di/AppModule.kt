package com.example.stockmarketapp.di

import android.content.Context
import androidx.room.Room
import com.example.stockmarketapp.data.network.base.getRetrofitInstance
import com.example.stockmarketapp.data.network.service.StockMarketService
import com.example.stockmarketapp.data.repository.StockMarketRepositoryImpl
import com.example.stockmarketapp.data.storage.StockMarketDatabase
import com.example.stockmarketapp.domain.repository.StockMarketRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Vazhapp on 18.08.2022
 */
@Module
class AppModule(
    private val dependencies: FeatureDependencies
) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = dependencies.getAppContext()

    @Provides
    @Singleton
    fun getService() =
        getRetrofitInstance(dependencies.getNetConfig()).create(StockMarketService::class.java)

    @Provides
    @Singleton
    fun getRepository(
        database: StockMarketDatabase,
        service: StockMarketService
    ): StockMarketRepository {
        return StockMarketRepositoryImpl(
            stockMarketDb = database,
            stockMarketService = service
        )
    }

    @Provides
    @Singleton
    fun getDb(): StockMarketDatabase {
        return Room.inMemoryDatabaseBuilder(
            dependencies.getAppContext(),
            StockMarketDatabase::class.java
        ).build()
    }
}