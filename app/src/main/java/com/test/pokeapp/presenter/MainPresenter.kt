package com.test.pokeapp.presenter

import com.test.apipoke.model.PokemonEntity
import com.test.core.DisposableManager
import com.test.networking.PokemonUseCase

class MainPresenter() {

    fun requestPokemonById(id: Int, dm: DisposableManager, successListener: (it: PokemonEntity) -> Unit, errorListener: () -> Unit) {
        PokemonUseCase.searchPokemonById(id, dm, successListener) {
            errorListener()
        }
    }
}

