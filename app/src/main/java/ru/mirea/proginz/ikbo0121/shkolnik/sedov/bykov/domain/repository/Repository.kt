package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.repository

import io.reactivex.Single
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPointDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto

/**
 * @author t.shkolnik
 */
interface Repository {

    fun getTrendingSearchesByTheRegion(region: String) : Single<List<String>>

    fun getInterestHistoryByTheRegion(region: String, keyword: String) : Single<List<GraphPointDto>>

    fun getInfo(keyword: String) : Single<InfoDto>

    fun getFullInfo(region: String, keyword: String) : Single<FullInfoDto>
}
