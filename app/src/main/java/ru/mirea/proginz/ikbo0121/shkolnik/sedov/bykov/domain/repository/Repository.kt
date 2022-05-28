package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.repository

import android.icu.text.IDNA
import io.reactivex.Single
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPoint
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InterestHistory

/**
 * @author t.shkolnik
 */
interface Repository {

    fun getTrendingSearchesByTheRegion(region: String) : Single<List<String>>

    fun getInterestHistoryByTheRegion(region: String, keyword: String) : Single<List<GraphPoint>>

    fun getInfo(keyword: String) : Single<InfoDto>

    fun getFullInfo(region: String, keyword: String) : Single<FullInfoDto>
}
