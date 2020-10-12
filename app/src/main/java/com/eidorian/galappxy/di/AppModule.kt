package com.eidorian.galappxy.di

import com.eidorian.galappxy.data.remote.ApiService
import com.eidorian.galappxy.data.remote.PictureRemoteDataSource
import com.eidorian.galappxy.data.repository.PictureRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/planetary/apod?api_key=z7tjP19W4ozonJnaU3yWseAVURdFhtqclDj2WSPw")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRepository(remoteDataSource: PictureRemoteDataSource) =
        PictureRepository(remoteDataSource)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(apiService: ApiService) = PictureRemoteDataSource(apiService)

}