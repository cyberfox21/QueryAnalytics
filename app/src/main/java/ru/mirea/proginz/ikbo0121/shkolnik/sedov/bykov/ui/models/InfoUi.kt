package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem

data class InfoUi(
    val id: Int,
    val shortText: String,
    val longText: String,
    val isExpanded: Boolean
) : DelegateItem {
    override fun id(): Any = id
    override fun content(): Any = shortText + longText + isExpanded
}