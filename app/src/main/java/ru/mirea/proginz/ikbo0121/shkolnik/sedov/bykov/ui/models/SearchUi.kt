package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem

data class SearchUi(val tag: String = "SearchUi") : DelegateItem {
    override fun id(): Any = tag
    override fun content(): Any = tag
}