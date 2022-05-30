package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.ItemTrendBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.AdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.TrendUi

class TrendAdapterDelegate(private val clickListener: (String, String) -> Unit) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind((item as TrendUi))
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is TrendUi

    class ViewHolder(
        private val binding: ItemTrendBinding,
        private val clickListener: (String, String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TrendUi) {
            with(binding) {
                region.text = item.region
                query.text = item.query
                root.setOnClickListener {
                    clickListener(item.query, item.region)
                }
            }
        }
    }
}