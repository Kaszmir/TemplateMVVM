package pl.kaszmir.templatemvvm.core.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.kaszmir.templatemvvm.core.di.koinInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {

        /**
        init koin (di library)
        define android context
        define list of modules
        list of modules is available in [koinInjector]
         **/

        startKoin {
            androidContext(this@App)
            modules(
                koinInjector
            )
        }
    }

}
