package com.test.networking

import com.test.apipoke.model.PokemonEntity

object ProvideTestPokemonEntity {

    //o ideal seria este json estar em um file.json e ser lido por um Reader, por conta de prazo não consigo deixar melhor
    fun providePokemonEntityMock(): PokemonEntity =
        provideTestGson().fromJson(
            JSON_POKEMON_ENTITY,
            PokemonEntity::class.java
        )

    private const val JSON_POKEMON_ENTITY = "{\n" +
            "  \"abilities\": [],\n" +
            "  \"base_experience\": 64,\n" +
            "  \"forms\": [\n" +
            "    {\n" +
            "      \"name\": \"bulbasaur\",\n" +
            "      \"url\": \"https://pokeapi.co/api/v2/pokemon-form/1/\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"game_indices\": [],\n" +
            "  \"height\": 7,\n" +
            "  \"held_items\": [],\n" +
            "  \"id\": 1,\n" +
            "  \"is_default\": true,\n" +
            "  \"location_area_encounters\": \"https://pokeapi.co/api/v2/pokemon/1/encounters\",\n" +
            "  \"moves\": [],\n" +
            "  \"name\": \"bulbasaur\",\n" +
            "  \"order\": 1,\n" +
            "  \"species\": {\n" +
            "    \"name\": \"bulbasaur\",\n" +
            "    \"url\": \"https://pokeapi.co/api/v2/pokemon-species/1/\"\n" +
            "  },\n" +
            "  \"sprites\": {\n" +
            "    \"back_default\": \"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png\",\n" +
            "    \"back_female\": null,\n" +
            "    \"back_shiny\": \"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png\",\n" +
            "    \"back_shiny_female\": null,\n" +
            "    \"front_default\": \"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png\",\n" +
            "    \"front_female\": null,\n" +
            "    \"front_shiny\": \"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png\",\n" +
            "    \"front_shiny_female\": null\n" +
            "  },\n" +
            "  \"stats\": [\n" +
            "    {\n" +
            "      \"base_stat\": 45,\n" +
            "      \"effort\": 0,\n" +
            "      \"stat\": {\n" +
            "        \"name\": \"speed\",\n" +
            "        \"url\": \"https://pokeapi.co/api/v2/stat/6/\"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"types\": [\n" +
            "    {\n" +
            "      \"slot\": 2,\n" +
            "      \"type\": {\n" +
            "        \"name\": \"poison\",\n" +
            "        \"url\": \"https://pokeapi.co/api/v2/type/4/\"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"weight\": 69\n" +
            "}"
}