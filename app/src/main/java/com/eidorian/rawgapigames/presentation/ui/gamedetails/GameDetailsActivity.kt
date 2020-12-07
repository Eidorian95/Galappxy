package com.eidorian.rawgapigames.presentation.ui.gamedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.databinding.ActivityGameDetailsBinding
import com.eidorian.rawgapigames.databinding.ActivityMainBinding
import com.eidorian.rawgapigames.presentation.ui.listgames.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailsBinding

    private val viewModel: GameDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_details)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}