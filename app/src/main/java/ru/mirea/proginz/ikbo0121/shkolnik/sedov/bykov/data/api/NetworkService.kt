package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPointDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto

/**
 * @author t.shkolnik
 */
interface NetworkService {

    @GET("/trending_searches/{region}")
    fun getTrendingSearchesByTheRegion(
        @Path("region") region: String
    ): Single<List<String>>

    @GET("/interest_over_time/{region}/{keyword}")
    fun getInterestHistoryByTheRegion(
        @Path("region") region: String,
        @Path("keyword") keyword: String,
    ): Single<List<GraphPointDto>>

    @GET("/info/{keyword>}")
    fun getInfoByTheKeyword(
        @Path("keyword") keyword: String,
    ): Single<InfoDto>

    @GET("/full_info/{region}/{keyword}")
    fun getFullInfoByTheRegion(
        @Path("region") region: String,
        @Path("keyword") keyword: String,
    ): Single<FullInfoDto>
}
