package com.eidorian.rawgapigames.data.remote

import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    fun getGamesList(): Single<GamesResponse>

    @GET("games")
    fun searchGameByName(@Query("search") search:String): Single<GamesResponse>
}