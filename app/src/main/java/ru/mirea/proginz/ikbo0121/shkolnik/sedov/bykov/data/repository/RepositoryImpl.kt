package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.repository

import io.reactivex.Single
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.api.NetworkService
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPointDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.repository.Repository
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class RepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : Repository {

    override fun getTrendingSearchesByTheRegion(region: String): Single<List<String>> {
        return networkService.getTrendingSearchesByTheRegion(region = region)
    }

    override fun getInterestHistoryByTheRegion(
        region: String,
        keyword: String
    ): Single<List<GraphPointDto>> {
        return networkService.getInterestHistoryByTheRegion(
            region = region,
            keyword = keyword
        )
    }

    override fun getInfo(keyword: String): Single<InfoDto> {
        return networkService.getInfoByTheKeyword(keyword)
    }

    override fun getFullInfo(region: String, keyword: String): Single<FullInfoDto> {
        return networkService.getFullInfoByTheRegion(region = region, keyword = keyword)
    }
}
