package com.test.networking

import com.test.apipoke.PokeIntegration
import com.test.apipoke.model.PokemonEntity
import com.test.core.DisposableManager
import io.reactivex.Observable

object PokemonUseCase {

    fun searchPokemonById(
        id: Int,
        dm: DisposableManager,
        callbackSuccess: (it: PokemonEntity) -> Unit,
        callbackError: (it: Throwable) -> Unit
    ) {
        
        val disposable = Observable
            .just(PokeIntegration::requestPokemon)
            .map { it(id) }
            .subscribe(callbackSuccess::invoke, callbackError::invoke)

        dm.addDisposable(disposable)
    }
}