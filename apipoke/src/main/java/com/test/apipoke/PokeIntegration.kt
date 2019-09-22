package com.test.apipoke

import com.test.apipoke.model.PokemonEntity
import me.sargunvohra.lib.pokekotlin.client.ErrorResponse
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient


object PokeIntegration {

    private val pokeApi = PokeApiClient()

    @Synchronized
    @Throws(ErrorResponse::class)
    fun requestPokemon(id: Int) = PokemonEntity(pokeApi.getPokemon(id))

    @Synchronized
    @Throws(ErrorResponse::class)
    fun requestListPokemon(offset: Int): ArrayList<PokemonEntity> {
        val limitResults = 25

        val list = ArrayList<PokemonEntity>(limitResults)

            pokeApi.getPokemonList(offset, limitResults).results.forEach {
                list.add(requestPokemon(it.id))
            }

        return list
    }

}