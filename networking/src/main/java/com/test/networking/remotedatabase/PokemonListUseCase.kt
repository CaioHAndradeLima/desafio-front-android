package com.test.networking.remotedatabase

import com.test.apipoke.PokeIntegration
import com.test.apipoke.model.PokemonEntity
import io.reactivex.Observable
import kotlin.reflect.KFunction1

object PokemonListUseCase {

    fun getAllPokemon(): Observable<KFunction1<Int, MutableList<PokemonEntity>>> =
        Observable.just(PokeIntegration::requestListPokemon)
}