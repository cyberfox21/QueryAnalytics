package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem

data class ChartUi(val labels: List<String>, val data: List<List<Int>>) : DelegateItem {
    override fun id(): Any = data
    override fun content(): Any = data
}