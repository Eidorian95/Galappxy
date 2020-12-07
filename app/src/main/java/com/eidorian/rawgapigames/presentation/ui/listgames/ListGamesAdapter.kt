package com.eidorian.rawgapigames.presentation.ui.listgames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.presentation.ui.listgames.ListGamesAdapter.ListViewHolder
import kotlinx.android.synthetic.main.game_card_item.view.*

class ListGamesAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var items: List<Game> = emptyList()

    fun setData(data: List<Game>?) {
        data?.let {
            items = data
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_card_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            //TODO: Implement data binding
            itemView.title_game.text = game.name
            Glide.with(itemView.context)
                .load(game.backgroundImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.image_game)
            itemView.rating_game.text = game.rating.toString()
            setPlatformList(game.platforms)

            //TODO: Set image rating (exceptional, recommended, meh, skip) using an Image Utils
        }

        private fun setPlatformList(platforms: List<Game.Platform>?) {
            itemView.list_platform.adapter = ListPlatformAdapter().apply { setData(platforms) }
        }
    }
}