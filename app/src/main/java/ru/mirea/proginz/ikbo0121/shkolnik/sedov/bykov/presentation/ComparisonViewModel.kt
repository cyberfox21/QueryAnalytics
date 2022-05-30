package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.ChartUi
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.QueryUi

class ComparisonViewModel : ViewModel() {

    private val _items = MutableLiveData<List<DelegateItem>>()
    val items: LiveData<List<DelegateItem>> = _items

    private val _queries = MutableLiveData<List<QueryUi>>()
    val queries: LiveData<List<QueryUi>> = _queries

    init {
        _queries.value = listOf(QueryUi(1), QueryUi(2))
    }

    fun loadData() {
        _items.postValue(
            listOf(
                ChartUi(
                    arrayListOf("September", "November", "December", "Do you remember?"),
                    listOf(
                        listOf(123, 23, 41, 40),
                        listOf(43, 1, 5, 50),
                    )
                )
            )
        )
    }

    fun addQuery() {
        queries.value.orEmpty().let {
            _queries.value = it.toMutableList().apply { add(QueryUi(it.size)) }
        }
    }

    fun deleteQuery() {
        queries.value.orEmpty().let {
            if (it.size > 2) {
                _queries.value = it.toMutableList().apply { removeAt(it.size - 1) }
            }
        }
    }
}