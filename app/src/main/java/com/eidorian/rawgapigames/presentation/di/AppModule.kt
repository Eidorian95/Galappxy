package com.eidorian.rawgapigames.presentation.di

import com.eidorian.rawgapigames.data.remote.ApiService
import com.eidorian.rawgapigames.data.remote.GamesRemoteDataSource
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.domain.usecases.GetGamesUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val original = chain.request().url()
                val url = original.newBuilder()
                    .addQueryParameter("key", "ed94dd161f7848eaa01139a0d1d45d9e")
                request.url(url.toString())
                return@addInterceptor chain.proceed(request.build())
            }
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRepository(remoteDataSource: GamesRemoteDataSource) =
        GamesRepository(remoteDataSource)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(apiService: ApiService) =
        GamesRemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideGamesUseCase(repository: GamesRepository) =
        GetGamesUseCase(repository)
}