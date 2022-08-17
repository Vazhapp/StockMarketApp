package com.example.stockmarketapp.data.csv

import com.example.stockmarketapp.domain.models.CompanyListing
import com.opencsv.CSVReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by Vazhapp on 17.08.2022
 */
class CompanyListingParser : CSVParser<CompanyListing> {

    override fun parse(stream: InputStream): List<CompanyListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return csvReader
            .readAll()
            .drop(1)
            .mapNotNull { line ->
                val symbol = line.getOrNull(0)
                val name = line.getOrNull(1)
                val exchange = line.getOrNull(2)

                CompanyListing(
                    symbol = symbol ?: return@mapNotNull null,
                    name = name ?: return@mapNotNull null,
                    exchange = exchange ?: return@mapNotNull null,
                )
            }.also {
                csvReader.close()
            }
    }
}