package com.example.stockmarketapp.data.network.base

import okhttp3.Interceptor

/**
 * Created by Vazhapp on 16.08.2022
 */
data class ClientConfig(
    val baseURL: String,
    val sslUnsafe: Boolean,
    val interceptors: List<Interceptor>
)
