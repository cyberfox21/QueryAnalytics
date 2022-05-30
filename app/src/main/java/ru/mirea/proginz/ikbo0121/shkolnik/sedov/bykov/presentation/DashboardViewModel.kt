package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.TrendUi

class DashboardViewModel : ViewModel() {

    private val _items = MutableLiveData<List<DelegateItem>>()
    val items: LiveData<List<DelegateItem>> = _items

    init {
        _items.postValue(
            listOf(
                TrendUi("Hello", "World"),
                TrendUi("How to paint button android api 35", "RU"),
                TrendUi("Kotlin or Kotlin?", "EN"),
                TrendUi("Hmmm.... Hmmmmm Hmmmm Hmmm", "CN"),
                TrendUi("Just another trending question", "World"),
                TrendUi("Why C++ is so bad?", "EN"),
            )
        )
    }
}