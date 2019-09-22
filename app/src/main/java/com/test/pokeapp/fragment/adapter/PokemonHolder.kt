package com.test.pokeapp.fragment.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.apipoke.model.PokemonEntity
import com.test.core.extension.load
import com.test.pokeapp.R

class PokemonHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val textViewTitle = itemView.findViewById<TextView>(R.id.tv_title)
    private val textViewWeight = itemView.findViewById<TextView>(R.id.tv_weight)
    private val textViewHeight = itemView.findViewById<TextView>(R.id.tv_height)

    init {
        val imageViewPokemon = itemView.findViewById<ImageView>(R.id.iv_picachu)
        imageViewPokemon.load(R.drawable.ic_picachu)
    }

    fun bind(pokemonEntity: PokemonEntity) {
        textViewTitle.text = pokemonEntity.name
        textViewWeight.text = textViewHeight.context.getString(R.string.weight, pokemonEntity.weight)
        textViewHeight.text = textViewHeight.context.getString(R.string.height, pokemonEntity.height)
    }
}