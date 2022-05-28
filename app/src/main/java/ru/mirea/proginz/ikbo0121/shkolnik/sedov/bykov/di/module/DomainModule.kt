package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.di.module

import dagger.Binds
import dagger.Module
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.data.repository.RepositoryImpl
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.domain.repository.Repository

/**
 * @author t.shkolnik
 */
@Module
interface DomainModule {

    @Binds
    fun bindRepository(repository: RepositoryImpl) : Repository
}
