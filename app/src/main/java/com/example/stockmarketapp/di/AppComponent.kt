package com.example.stockmarketapp.di

import com.example.stockmarketapp.MainActivity
import com.example.stockmarketapp.presentation.companyList.CompanyListFragment
import dagger.Component

/**
 * Created by Vazhapp on 18.08.2022
 */
@Component(
    modules = [AppModule::class],
    dependencies = [FeatureDependencies::class]
)
interface AppComponent {
    fun inject(fragment: CompanyListFragment)
}