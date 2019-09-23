package com.test.networking

import com.test.apipoke.PokeIntegration
import com.test.networking.ProvideTestPokemonEntity.providePokemonEntityMock
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PokemonByIdUseCaseTest {

    @Test
    fun whenRequestUseCase_shouldReturnPokemon() {
        val pokemon = providePokemonEntityMock()

        mockkObject(PokeIntegration)
        every { PokeIntegration.requestPokemon(pokemon.id) } returns pokemon

        PokemonByIdUseCase
            .searchPokemonById()
            .map { it(pokemon.id) }
            .subscribe {
                assertEquals(pokemon, it)
            }

    }
}