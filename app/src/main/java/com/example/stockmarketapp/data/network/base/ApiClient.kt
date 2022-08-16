package com.example.stockmarketapp.data.network.base

import com.example.stockmarketapp.data.ssl.UnsafeTrustManagerImpl
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.X509TrustManager

/**
 * Created by Vazhapp on 16.08.2022
 */

fun getOkHttpInstance(
    interceptors: List<Interceptor> = emptyList(),
    sslUnsafe: Boolean = false
): OkHttpClient {
    val builder = OkHttpClient.Builder()

    builder.readTimeout(60, TimeUnit.SECONDS)
    builder.connectTimeout(60, TimeUnit.SECONDS)

    if (sslUnsafe) {
        builder.connectionSpecs(
            listOf(
                ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT).build(),
                ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2).allEnabledCipherSuites().build()
            )
        )
        builder.sslSocketFactory(
            UnsafeTrustManagerImpl.trustAllSslSocketFactory,
            UnsafeTrustManagerImpl.trustAllCerts[0] as X509TrustManager
        )
        builder.hostnameVerifier { _, _ -> true }
    }

    interceptors.forEach {
        builder.addInterceptor(it)
    }

    return builder.build()
}

fun getRetrofitInstance(clientConfig: ClientConfig): Retrofit {
    return Retrofit.Builder()
        .client(
            getOkHttpInstance(
                interceptors = clientConfig.interceptors,
                sslUnsafe = clientConfig.sslUnsafe
            )
        ).baseUrl(
            clientConfig.baseURL
        ).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}