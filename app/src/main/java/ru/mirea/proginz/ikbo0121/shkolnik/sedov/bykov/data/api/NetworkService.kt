package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPoint
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InterestHistory

/**
 * @author t.shkolnik
 */
interface NetworkService {

    @GET("/trending_searches/<region>")
    fun getTrendingSearchesByTheRegion(
        @Query("region") region: String
    ): Single<List<String>>

    @GET("/interest_over_time/<string:region>/<string:keyword>")
    fun getInterestHistoryByTheRegion(
        @Query("region") region: String,
        @Query("keyword") keyword: String,
    ): Single<List<GraphPoint>>

    @GET("/info/<string:keyword>'")
    fun getInfoByTheKeyword(
        @Query("keyword") keyword: String,
    ): Single<InfoDto>

    @GET("/full_info/<string:region>/<string:keyword>")
    fun getFullInfoByTheRegion(
        @Query("region") region: String,
        @Query("keyword") keyword: String,
    ): Single<FullInfoDto>
}
