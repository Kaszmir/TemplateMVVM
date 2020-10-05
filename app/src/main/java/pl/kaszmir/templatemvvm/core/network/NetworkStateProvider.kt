package pl.kaszmir.templatemvvm.core.network

interface NetworkStateProvider {

    fun isNetworkAvailable(): Boolean

}