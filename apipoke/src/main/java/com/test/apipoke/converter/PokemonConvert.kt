package com.test.apipoke.converter

import com.test.apipoke.model.PokemonEntity
import me.sargunvohra.lib.pokekotlin.model.Pokemon

object PokemonConvert {

    fun pokemonApiToPokemonEntity(pokemon: Pokemon) =
        PokemonEntity(
            id = pokemon.id,
            name = pokemon.name,
            baseExperience = pokemon.baseExperience,
            height = pokemon.height,
            isDefault = pokemon.isDefault,
            order = pokemon.order,
            weight = pokemon.weight,
            species = pokemon.species,
            abilities = pokemon.abilities,
            forms = pokemon.forms,
            heldItems = pokemon.heldItems,
            moves = pokemon.moves,
            stats = pokemon.stats,
            types = pokemon.types,
            sprites = pokemon.sprites
        )

}