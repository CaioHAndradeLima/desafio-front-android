package com.test.networking

import com.test.apipoke.PokeIntegration
import com.test.apipoke.model.PokemonEntity
import io.reactivex.Observable
import kotlin.reflect.KFunction1

object PokemonByIdUseCase {

    fun searchPokemonById(): Observable<KFunction1<Int, PokemonEntity>> = Observable
        .just(PokeIntegration::requestPokemon)

}