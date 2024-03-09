package com.example.aviatickets.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aviatickets.OfferListAdapter
import com.example.aviatickets.R
import com.example.aviatickets.databinding.FragmentOfferListBinding
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.model.network.ApiClient
import kotlinx.coroutines.launch

class OfferListFragment : Fragment() {
    private var _binding: FragmentOfferListBinding? = null
    private val binding get() = _binding!!

    private val offerListAdapter = OfferListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfferListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSorting()
        fetchOffers()
    }

    private fun setupRecyclerView() {
        binding.offerList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = offerListAdapter
        }
    }

    private fun setupSorting() {
        binding.sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.sort_by_price -> offerListAdapter.sortByPrice()
                R.id.sort_by_duration -> offerListAdapter.sortByDuration()
            }
        }
    }

    private fun fetchOffers() {
        lifecycleScope.launch {
            val offers = ApiClient.apiService.getOffers()
            offerListAdapter.setItems(offers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
