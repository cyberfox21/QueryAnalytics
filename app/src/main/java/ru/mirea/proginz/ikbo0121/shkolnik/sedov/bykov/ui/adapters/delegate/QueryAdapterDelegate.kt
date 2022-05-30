package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.ItemQueryBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.AdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.QueryUi

class QueryAdapterDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding = ItemQueryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind((item as QueryUi))
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is QueryUi

    class ViewHolder(private val binding: ItemQueryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QueryUi) {
            with(binding) {
                query.setText(item.text)
                region.setText(item.region)
            }
        }
    }
}