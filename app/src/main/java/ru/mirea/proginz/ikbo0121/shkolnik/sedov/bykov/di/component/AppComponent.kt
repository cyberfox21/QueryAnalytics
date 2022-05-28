package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.di.component

import dagger.Component

/**
 * @author t.shkolnik
 */
@Component
abstract class AppComponent {

    @Component.Factory
    interface Factory {
        fun create() : AppComponent
    }
}
