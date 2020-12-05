package com.eidorian.rawgapigames.data.remote

import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    fun getGamesListRxJava(): Single<GamesResponse>
}