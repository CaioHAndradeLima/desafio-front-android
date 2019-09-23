package com.gizmin.localdatabase

import com.gizmin.localdatabase.model.PokemonLocalEntity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PokemonCapturedLocalTest {

    @Test
    fun whenSavePokemonAndGetPokemon_shouldReturnPokemon() {
        val pokemonLocalEntity = getPokemonLocalEntityTest()
        val pokemonDao = provideDataBaseTest()
            .pokemonDao()

        pokemonDao
            .addPokemon(pokemonLocalEntity)

        assert(
            pokemonDao
                .fetchPokemon()
                .isNotEmpty()
        )

        pokemonDao
            .removePokemon(pokemonLocalEntity)

        assert(
            pokemonDao
                .fetchPokemon()
                .isEmpty()
        )
    }

    private fun getPokemonLocalEntityTest() = PokemonLocalEntity(
        1,
        "picachu",
        10,
        10,
        true,
        4,
        56
    )
}