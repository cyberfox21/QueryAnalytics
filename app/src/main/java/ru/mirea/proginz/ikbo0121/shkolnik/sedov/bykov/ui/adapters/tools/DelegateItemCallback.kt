package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DelegateItemCallback : DiffUtil.ItemCallback<DelegateItem>() {

    override fun areItemsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean =
        oldItem::class == newItem::class && oldItem.id() == newItem.id()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean =
        oldItem.content() == newItem.content()
}