package com.example.stockmarketapp.data.csv

import java.io.InputStream

/**
 * Created by Vazhapp on 17.08.2022
 */
interface CSVParser<T> {
    fun parse(stream: InputStream): List<T>
}