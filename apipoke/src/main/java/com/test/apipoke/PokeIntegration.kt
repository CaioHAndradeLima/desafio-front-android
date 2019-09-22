package com.test.apipoke

import com.test.apipoke.model.PokemonEntity
import me.sargunvohra.lib.pokekotlin.client.ErrorResponse
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient


object PokeIntegration {

    private val pokeApi = PokeApiClient()

    @Synchronized
    @Throws(ErrorResponse::class)
    fun requestPokemon(id: Int) = PokemonEntity(pokeApi.getPokemon(id))

}