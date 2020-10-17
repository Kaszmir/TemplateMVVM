package pl.kaszmir.templatemvvm.core.di

import org.koin.core.module.Module

/** list of all DI modules which will be used in the app **/
val koinInjector: List<Module> = appModule
    .plus(networkModule)
    .plus(databaseModule)
    .plus(featureModules)