package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.FragmentDashboardBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation.DashboardViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.core.BaseAdapter
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate.TrendAdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.fragments.DashboardFragmentDirections.Companion.actionDashboardFragmentToStatisticsFragment

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val adapter: BaseAdapter = BaseAdapter()
    private val viewModel: DashboardViewModel by viewModels()
    private val binding: FragmentDashboardBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSearch.setOnClickListener { openStatistics() }

        binding.listDashboard.adapter = adapter.apply {
            addDelegate(TrendAdapterDelegate { query, region -> openStatistics(query, region) })
        }

        viewModel.items.observe(viewLifecycleOwner) { items ->
            binding.viewEmpty.root.isGone = items.isNotEmpty()
            adapter.submitList(items)
        }
    }

    private fun openStatistics(query: String? = null, region: String? = null) {
        findNavController().navigate(actionDashboardFragmentToStatisticsFragment(query, region))
    }
}