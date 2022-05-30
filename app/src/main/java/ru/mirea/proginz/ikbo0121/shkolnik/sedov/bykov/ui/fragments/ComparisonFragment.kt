package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.FragmentComparisonBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation.ComparisonViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.core.BaseAdapter
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate.ChartAdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate.QueryAdapterDelegate

class ComparisonFragment : Fragment(R.layout.fragment_comparison) {

    private val adapter: BaseAdapter = BaseAdapter()
    private val queriesAdapter: BaseAdapter = BaseAdapter()
    private val viewModel: ComparisonViewModel by viewModels()
    private val binding: FragmentComparisonBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }
        viewModel.queries.observe(viewLifecycleOwner) { queriesAdapter.submitList(it) }

        binding.viewCompare.addButton.setOnClickListener { viewModel.addQuery() }
        binding.viewCompare.deleteButton.setOnClickListener { viewModel.deleteQuery() }
        binding.viewCompare.compareButton.setOnClickListener { viewModel.loadData() }
        binding.viewCompare.queriesList.adapter = queriesAdapter.apply {
            addDelegate(QueryAdapterDelegate())
        }

        binding.listComparison.adapter = adapter.apply {
            addDelegate(ChartAdapterDelegate())
        }
    }
}