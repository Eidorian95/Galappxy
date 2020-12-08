package com.eidorian.rawgapigames.presentation.ui.gamedetails

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.eidorian.rawgapigames.domain.usecases.GameDetailsUseCase
import com.eidorian.rawgapigames.presentation.ViewState
import com.eidorian.rawgapigames.presentation.model.GameDetail
import com.eidorian.rawgapigames.utils.Status.*

class GameDetailsViewModel @ViewModelInject constructor(
    private val useCase: GameDetailsUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var id: Int? = 0
    private val _viewState = MutableLiveData<ViewState<GameDetail>>()

    init {
        id = savedStateHandle.get<Int>("GAME_ID")
        getGameDetails(id!!)
    }

    private fun getGameDetails(id: Int) {
        useCase.getGameDetails(id,
            {
                _viewState.value = ViewState(SUCCESS, it)
            }, {
                _viewState.value = ViewState(ERROR, null, it.message)
            })
    }

    fun getDetails():LiveData<ViewState<GameDetail>> = _viewState
}

