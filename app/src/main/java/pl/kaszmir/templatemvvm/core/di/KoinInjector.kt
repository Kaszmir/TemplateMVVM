package pl.kaszmir.templatemvvm.core.di

import org.koin.core.module.Module

/** list of di modules which will be use in the app **/
val koinInjector: List<Module> = listOf(
    networkModule
)