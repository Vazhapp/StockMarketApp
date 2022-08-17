package com.example.stockmarketapp.presentation.companyList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stockmarketapp.domain.models.CompanyListing
import com.example.stockmarketapp.domain.useCase.GetStockListUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Vazhapp on 17.08.2022
 */
class CompanyListingViewModel @Inject constructor(
    private val getStockListUseCase: GetStockListUseCase
) : ViewModel() {

    private val _companiesMutableLiveData = MutableLiveData<List<CompanyListing>>()

    val companiesLiveData: LiveData<List<CompanyListing>>
        get() = _companiesMutableLiveData

    fun onEvent(event: CompanyListingEvent) {
        when(event) {
            is CompanyListingEvent.OnSearchQuery -> {

            }
            CompanyListingEvent.Refresh -> {
                getCompanyListing()
            }
        }
    }

    private fun getCompanyListing() {
        getStockListUseCase.execute().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
            _companiesMutableLiveData.postValue(it)
        }
    }
}