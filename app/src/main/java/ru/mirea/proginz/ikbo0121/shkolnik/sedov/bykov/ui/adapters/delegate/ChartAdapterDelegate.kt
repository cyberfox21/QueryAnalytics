package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.R
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.ItemChartBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.AdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.ChartUi


class ChartAdapterDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding = ItemChartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind((item as ChartUi))
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is ChartUi

    class ViewHolder(
        private val binding: ItemChartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChartUi) {
            with(binding.chart) {
                setColorArray(itemView.context.resources.getIntArray(R.array.chart_colors))
                setBottomTextList(ArrayList(item.labels))
                setDataList(ArrayList(item.data.map { ArrayList(it) }))
            }
        }
    }
}