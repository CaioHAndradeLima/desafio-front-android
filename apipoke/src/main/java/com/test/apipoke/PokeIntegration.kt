package com.test.apipoke

import com.test.apipoke.converter.PokemonConvert.pokemonApiToPokemonEntity
import com.test.apipoke.model.PokemonEntity
import me.sargunvohra.lib.pokekotlin.client.ErrorResponse
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient


object PokeIntegration {

    private val pokeApi = PokeApiClient()

    @Synchronized
    @Throws(ErrorResponse::class)
    fun requestPokemon(id: Int) = pokemonApiToPokemonEntity((pokeApi.getPokemon(id)))

    @Synchronized
    @Throws(ErrorResponse::class)
    fun requestListPokemon(offset: Int): MutableList<PokemonEntity> {
        val limitResults = 25

        val list = ArrayList<PokemonEntity>(limitResults)

            pokeApi.getPokemonList(offset, limitResults).results.forEach {
                list.add(requestPokemon(it.id))
            }

        return list
    }

}