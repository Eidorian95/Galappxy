package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.utils.Status.SUCCESS
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.DisposableHandle
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: GamesRepository) {

    suspend fun getGamesList(
        onSuccess: (games: List<Game>) -> Unit,
        onError: (message: String) -> Unit
    ) {
        val response = repository.getGamesList()
        when (response.status) {
            SUCCESS -> {
                val data = response.data as GamesResponse
                val games: List<Game> = data.results.map { result ->
                    Game(
                        result.id,
                        result.name,
                        result.released,
                        result.backgroundImage,
                        result.rating,
                        result.ratingTop
                    )
                }
                onSuccess(games)
            }
            else -> response.message?.let { onError(it) }
        }
    }

    fun getGamesListRxJava(
        onSuccess: ((t: List<Game>?) -> Unit),
        onError: ((t: Throwable) -> Unit)
    ) {
        CompositeDisposable().add(
            repository.getGamesListRxJava()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ games ->
                    onSuccess(games?.results?.map {
                        Game(
                            it.id,
                            it.name,
                            it.released,
                            it.backgroundImage,
                            it.rating,
                            it.ratingTop
                        )
                    })
                }, { t ->
                    onError(t)
                })
        )
    }
}