package com.eidorian.rawgapigames.presentation.ui.gamedetails

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.eidorian.rawgapigames.domain.usecases.GameDetailsUseCase

class GameDetailsViewModel @ViewModelInject constructor(
    private val useCase: GameDetailsUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var id: Int? = 0

    init {
        id = savedStateHandle.get<Int>("GAME_ID")
        getGameDetails(id!!)
    }

    private fun getGameDetails(id: Int) {
        useCase.getGameDetails(id)
    }
}

