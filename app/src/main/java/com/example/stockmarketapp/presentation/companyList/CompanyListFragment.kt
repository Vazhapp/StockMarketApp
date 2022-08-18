package com.example.stockmarketapp.presentation.companyList

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockmarketapp.databinding.FragmentCompanyListBinding
import com.example.stockmarketapp.presentation.adapter.CompanyListAdapter
import com.example.stockmarketapp.util.makeObservable


class CompanyListFragment : Fragment() {

    private val companyListingViewModel by viewModels<CompanyListingViewModel>()

    private var _binding: FragmentCompanyListBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun init() {
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        companyListingViewModel.getCompanyListing()

        var companyAdapter = companyListingViewModel.companiesLiveData.value?.let {
            CompanyListAdapter(it) { company ->
                d("Clicked", "Clicked ${company.name}")
            }
        }

        binding.rvCompanyList.apply {
            adapter = companyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}