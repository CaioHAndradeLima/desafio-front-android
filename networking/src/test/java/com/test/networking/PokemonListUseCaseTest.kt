package com.test.networking

import com.test.apipoke.PokeIntegration
import com.test.networking.remotedatabase.PokemonListUseCase
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PokemonListUseCaseTest {

    @Test
    fun whenRequestUseCase_shouldReturnListPokemon() {
        val pokemon = ProvideTestPokemonEntity.providePokemonEntityMock()
        val listPokemon = mutableListOf(pokemon)
        val offSet = 0
        mockkObject(PokeIntegration)
        every { PokeIntegration.requestListPokemon(offSet) } returns listPokemon

        PokemonListUseCase
            .getAllPokemon()
            .map { it(offSet) }
            .subscribe {
                assertEquals(listPokemon, it)
            }
    }
}