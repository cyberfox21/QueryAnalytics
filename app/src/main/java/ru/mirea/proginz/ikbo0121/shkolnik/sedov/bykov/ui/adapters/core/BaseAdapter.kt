package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.core

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.AdapterDelegate
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItemCallback

open class BaseAdapter : ListAdapter<DelegateItem, RecyclerView.ViewHolder>(DelegateItemCallback()) {

    private val delegates: MutableList<AdapterDelegate> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType >= 0 && viewType < delegates.size) {
            delegates[viewType].onCreateViewHolder(parent)
        } else {
            EmptyViewHolder(parent.context)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            delegates[getItemViewType(position)].onBindViewHolder(
                holder,
                getItem(position),
                position
            )
        } catch (e: ArrayIndexOutOfBoundsException) {
            throw Exception("Can't find delegate for item at position $position: ${getItem(position)}")
        }
    }

    fun addDelegate(delegate: AdapterDelegate) {
        delegates.add(delegate)
    }

    override fun getItemViewType(position: Int): Int {
        return delegates.indexOfFirst { it.isOfViewType(currentList[position]) }
    }

    private class EmptyViewHolder(context: Context) : RecyclerView.ViewHolder(View(context))
}