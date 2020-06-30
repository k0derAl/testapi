package ru.k0der.simpleapp.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.k0der.simpleapp.BuildConfig
import ru.k0der.simpleapp.data.BaseAPI
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        protocols(listOf(Protocol.HTTP_1_1))
        build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = with(Retrofit.Builder()) {
        addConverterFactory(GsonConverterFactory.create())
        client(client)
        baseUrl(BuildConfig.API_BASE_URL)
        build()
    }

    @Provides
    @JvmStatic
    fun provideApi(retrofit: Retrofit): BaseAPI = retrofit.create(BaseAPI::class.java)
}