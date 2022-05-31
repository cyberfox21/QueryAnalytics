package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.FragmentStatisticsBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation.StatisticsViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.core.BaseAdapter
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate.ChartAdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate.InfoAdapterDelegate

class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private val adapter: BaseAdapter = BaseAdapter()
    private val viewModel: StatisticsViewModel by viewModels()
    private val args: StatisticsFragmentArgs by navArgs()
    private val binding: FragmentStatisticsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { activity?.onBackPressed() }

        binding.viewSearch.searchButton.setOnClickListener { viewModel.loadData() }
        binding.listStatistics.adapter = adapter.apply {
            addDelegate(InfoAdapterDelegate { viewModel.onInfoClicked(it) })
            addDelegate(ChartAdapterDelegate())
        }

        viewModel.query.observe(viewLifecycleOwner) { query ->
            with(binding.viewSearch.queryView.query) {
                setText(query)
                setSelection(query.length)
            }
        }

        viewModel.region.observe(viewLifecycleOwner) { region ->
            binding.viewSearch.queryView.region.setText(region)
        }

        viewModel.items.observe(viewLifecycleOwner) { items ->
            binding.viewEmpty.root.isGone = items.isNotEmpty()
            adapter.submitList(items)
        }

        viewModel.init(args.query, args.region)
    }
}