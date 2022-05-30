package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem

data class QueryUi(val id: Int, val text: String = "", val region: String = "") : DelegateItem {
    override fun id(): Any = id
    override fun content(): Any = text + region
}