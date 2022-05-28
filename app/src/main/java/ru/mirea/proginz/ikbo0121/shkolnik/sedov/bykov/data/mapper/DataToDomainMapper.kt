package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.mapper

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.FullInfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.GraphPointDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.entity.InfoDto
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.entity.FullInfo
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.entity.GraphPoint
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.entity.Info

/**
 * @author t.shkolnik
 */
internal class DataToDomainMapper {

    private fun mapGraphPointDtoToGraphPoint(graphPointDto: GraphPointDto) : GraphPoint {
        return GraphPoint(
            date = graphPointDto.date,
            popularity = graphPointDto.popularity
        )
    }

    fun mapInfoDtoToInfo(infoDto: InfoDto) : Info {
        return Info(
            full = infoDto.full,
            pageFound = infoDto.pageFound,
            short = infoDto.short
        )
    }

    fun mapFullInfoDtoToFullInfo(fullInfoDto: FullInfoDto) : FullInfo {
        return FullInfo(
            full = fullInfoDto.full,
            graph = (fullInfoDto.graph.map {
                mapGraphPointDtoToGraphPoint(it)
            }),
            pageFound = fullInfoDto.pageFound,
            short = fullInfoDto.short
        )
    }
}
