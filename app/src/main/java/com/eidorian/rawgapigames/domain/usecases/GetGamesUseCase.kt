package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.toGame
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.presentation.model.Game
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: GamesRepository) {

    fun getGamesListRxJava(
        onSuccess: ((t: List<Game>?) -> Unit),
        onError: ((t: Throwable) -> Unit)
    ) {
        CompositeDisposable().add(
            repository.getGamesListRxJava()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gamesResponse ->
                    onSuccess(gamesResponse.toGame())
                }, { t ->
                    onError(t)
                })
        )
    }
}