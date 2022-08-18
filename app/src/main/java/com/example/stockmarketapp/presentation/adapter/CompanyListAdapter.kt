package com.example.stockmarketapp.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmarketapp.databinding.CompanyListItemBinding
import com.example.stockmarketapp.domain.models.CompanyListing
import com.example.stockmarketapp.util.viewBinding

/**
 * Created by Vazhapp on 17.08.2022
 */
class CompanyListAdapter(
    val data: List<CompanyListing>,
    private val itemClickListener: (company: CompanyListing) -> Unit
) : RecyclerView.Adapter<CompanyListAdapter.CompanyListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val binding = parent.viewBinding(CompanyListItemBinding::inflate, false)
        return CompanyListViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        val company = data[position]

        holder.bind(company)
    }

    override fun getItemCount() = data.size

    class CompanyListViewHolder(private val binding: CompanyListItemBinding, val itemClicker: (company: CompanyListing) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        private var currentCompanyListing: CompanyListing? = null

        init {
            binding.root.setOnClickListener {
                currentCompanyListing?.let {
                    itemClicker(it)
                }
            }
        }

        fun bind(company: CompanyListing) {
            currentCompanyListing = company
            with(binding) {
                tvcompanySymbol.text = company.symbol
                tvCompanyName.text = company.name
                tvCompanyExchange.text = company.exchange
            }
        }
    }
}