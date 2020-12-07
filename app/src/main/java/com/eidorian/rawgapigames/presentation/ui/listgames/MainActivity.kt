package com.eidorian.rawgapigames.presentation.ui.listgames

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.databinding.ActivityMainBinding
import com.eidorian.rawgapigames.utils.Status.SUCCESS
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val recycler = binding.listGames
        val adapter = ListGamesAdapter()
        recycler.adapter = adapter
        recycler.hasFixedSize()

        viewModel.getGamesList().observe(this, Observer { viewState ->
            when (viewState.state) {
                SUCCESS -> {
                    adapter.setData(viewState.data)
                }
                else -> binding.listGames.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            }
        })

        binding.btSearch.setOnClickListener {
            val name = binding.etSearchGame.text.toString()
            viewModel.searchGame(name)
        }
    }

    private fun orderGames(ordering: String) {
        val searchText = binding.etSearchGame.text.toString()
        viewModel.orderGamesBy(ordering, searchText)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ordering_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        orderGames("-${item.title.toString().toLowerCase(Locale.ROOT)}")
        return true
    }
}