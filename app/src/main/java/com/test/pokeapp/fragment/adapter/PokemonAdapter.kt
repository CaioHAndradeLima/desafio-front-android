package com.test.pokeapp.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.apipoke.model.PokemonEntity
import com.test.pokeapp.R

class PokemonAdapter(private val listPokemon: List<PokemonEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokemonHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PokemonHolder).bind(listPokemon[position])
    }

    override fun getItemCount(): Int = listPokemon.size
}