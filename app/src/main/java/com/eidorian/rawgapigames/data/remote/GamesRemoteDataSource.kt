package com.eidorian.rawgapigames.data.remote

import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {

    suspend fun getTodayPicture() = getResult { apiService.getTodayPicture() }
}