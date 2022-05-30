package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.databinding.ItemInfoBinding
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.AdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.InfoUi

class InfoAdapterDelegate(private val clickListener: (Int) -> Unit) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind((item as InfoUi))
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is InfoUi

    class ViewHolder(
        private val binding: ItemInfoBinding,
        private val clickListener: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InfoUi) {
            with(binding) {
                buttonMore.isInvisible = item.isExpanded
                buttonLess.isInvisible = !item.isExpanded
                content.text = if (item.isExpanded) item.longText else item.shortText
                root.setOnClickListener { clickListener(item.id) }
            }
        }
    }
}