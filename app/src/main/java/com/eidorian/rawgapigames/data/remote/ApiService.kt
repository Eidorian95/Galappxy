package com.eidorian.rawgapigames.data.remote

import com.eidorian.rawgapigames.data.entity.response.GameDetailsResponse
import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    fun getGamesList(): Single<GamesResponse>

    @GET("games")
    fun searchGameByName(@Query("search") search: String): Single<GamesResponse>

    @GET("games")
    fun orderGamesBy(
        @Query("ordering") ordering: String,
        @Query("search") search: String
    ): Single<GamesResponse>


    @GET("games/{id}")
    fun getGameDetails(@Path("id") id: Int): Single<GameDetailsResponse>

}