package com.eidorian.rawgapigames.presentation.ui.listgames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.presentation.model.Game.Platform
import com.eidorian.rawgapigames.utils.ImageUtils
import kotlinx.android.synthetic.main.game_card_item.view.*
import kotlinx.android.synthetic.main.platform_item.view.*

class ListPlatformAdapter: RecyclerView.Adapter<ListPlatformAdapter.ListPlatformViewHolder>() {

    private var items:List<Platform> = emptyList()

    fun setData(data: List<Platform>?) {
        data?.let {
            items = data
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlatformViewHolder {
        return ListPlatformViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.platform_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListPlatformViewHolder, position: Int) {
       holder.bind(items[position])
    }

    class ListPlatformViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(platform: Platform) {
            //TODO: Implement data binding
            itemView.image_platform.setImageResource(ImageUtils.getImageDrawable(platform.slug))
        }
    }
}