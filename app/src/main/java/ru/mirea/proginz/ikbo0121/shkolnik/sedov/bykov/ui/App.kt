package ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.ui

import android.app.Application
import ru.mirea.proginz.ikbo0121.shkolnik.sedov.bykov.di.DaggerAppComponent

/**
 * @author t.shkolnik
 */
class App : Application() {
    val appComponent = DaggerAppComponent.factory().create()
}
