package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.adapters.tools.DelegateItem
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.ChartUi
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui.models.InfoUi

class StatisticsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<DelegateItem>>()
    val items: LiveData<List<DelegateItem>> = _items

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query

    private val _region = MutableLiveData<String>()
    val region: LiveData<String> = _region

    fun init(initQuery: String?, initRegion: String?) {
        if (query.value == null) initQuery?.let { _query.value = it }
        if (region.value == null) initRegion?.let { _region.value = it }
    }

    fun loadData() {
        _items.postValue(
            listOf(
                InfoUi(
                    1,
                    "Lorem ipsum dolor sit amet...",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor justo at nulla faucibus, in tincidunt tortor imperdiet. Mauris fermentum non metus euismod ornare. Pellentesque eu lectus metus. Nulla ac urna commodo, tincidunt erat eget, placerat nisi. Fusce mattis mi sed est tincidunt eleifend. Donec maximus lectus arcu. Phasellus vel rhoncus nibh, a fermentum purus. Suspendisse potenti. Fusce eget gravida dolor, a gravida mi. Nunc eget lectus auctor, tempor erat quis, tempus nisi. Pellentesque cursus porttitor purus, non vestibulum sem convallis quis. Proin lectus odio, tincidunt vel rhoncus sed, accumsan sed quam.",
                    false
                ),
                ChartUi(
                    arrayListOf("September", "November", "December", "Do you remember?"),
                    listOf(listOf(123, 23, 41, 40))
                )
            )
        )
    }

    fun onInfoClicked(id: Int) {
        items.value?.let { items ->
            _items.postValue(
                items.map { item ->
                    if (item is InfoUi && item.id == id) {
                        item.copy(isExpanded = !item.isExpanded)
                    } else {
                        item
                    }
                }
            )
        }
    }
}