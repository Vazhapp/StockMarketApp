package com.example.stockmarketapp.di

import android.content.Context
import com.example.stockmarketapp.data.network.base.ClientConfig

/**
 * Created by Vazhapp on 18.08.2022
 */
interface FeatureDependencies {

    fun getNetConfig(): ClientConfig

    fun getAppContext(): Context
}