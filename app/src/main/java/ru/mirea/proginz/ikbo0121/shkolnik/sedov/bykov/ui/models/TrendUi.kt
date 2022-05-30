package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem

data class TrendUi(val query: String, val region: String) : DelegateItem {
    override fun id(): Any = query
    override fun content(): Any = query + region
}