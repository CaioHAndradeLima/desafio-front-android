package com.test.apipoke.model

import me.sargunvohra.lib.pokekotlin.model.*

data class PokemonEntity(
    private val pokemon: Pokemon,
    val id: Int = pokemon.id,
    val name: String = pokemon.name,
    val baseExperience: Int = pokemon.baseExperience,
    val height: Int = pokemon.height,
    val isDefault: Boolean = pokemon.isDefault,
    val order: Int = pokemon.order,
    val weight: Int = pokemon.weight,
    val species: NamedApiResource = pokemon.species,
    val abilities: List<PokemonAbility> = pokemon.abilities,
    val forms: List<NamedApiResource> = pokemon.forms,
    val heldItems: List<PokemonHeldItem> = pokemon.heldItems,
    val moves: List<PokemonMove> = pokemon.moves,
    val stats: List<PokemonStat> = pokemon.stats,
    val types: List<PokemonType> = pokemon.types,
    val sprites: PokemonSprites = pokemon.sprites
)