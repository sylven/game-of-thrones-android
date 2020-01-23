package com.silviuchirvasa.gameofthrones.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.silviuchirvasa.gameofthrones.R
import com.silviuchirvasa.gameofthrones.data.network.model.NetworkCharacter
import com.silviuchirvasa.gameofthrones.util.inflate
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(private val characters: List<NetworkCharacter>, private val listener: (NetworkCharacter) -> Unit) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_character))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(characters[position], listener)

    override fun getItemCount() = characters.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NetworkCharacter, listener: (NetworkCharacter) -> Unit) = with(itemView) {
            tv_name.text = item.name
            Glide.with(context)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate()
            .override(333, 500) // To allow parallax effect
            .into(iv_bg)

            setOnClickListener { listener(item) }
        }
    }
}