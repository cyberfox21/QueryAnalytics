package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.usecase

import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.repository.Repository
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class GetInterestHistoryUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(region: String, keyword: String) =
        repository.getInterestHistoryByTheRegion(region, keyword)
}
