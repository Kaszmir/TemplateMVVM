package pl.kaszmir.templatemvvm.core.di


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.kaszmir.templatemvvm.BuildConfig
import pl.kaszmir.templatemvvm.core.app.baseUrl
import pl.kaszmir.templatemvvm.fatures.data.RickAndMortyApi
import retrofit2.Retrofit

val networkModule = module {

    /**
     * enable http logs in debug version
     * disable http logs in release version
     */

    single<Interceptor> {
        HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }
    }

    /**
     * define [OkHttpClient] object as singleton
     * set our HttpLoggingInterceptor as interceptor
     */

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }


    /**
     * create a singleton instance of [Retrofit]
     * set base api url from [baseUrl]
     * set [OkHttpClient] as a client
     */

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get<OkHttpClient>())
            .build()
    }


    /**
     * create a singleton instance of interface [RickAndMortyApi]
     * to communication with backend server
     */

    single {
        get<Retrofit>().create(RickAndMortyApi::class.java)
    }

}