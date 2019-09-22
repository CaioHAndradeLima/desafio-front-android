package com.test.pokeapp.presenter

import com.test.apipoke.model.PokemonEntity
import com.test.core.view.DisposableManager
import com.test.networking.PokemonByIdUseCase
import com.test.networking.PokemonListUseCase

class MainPresenter {

    fun requestPokemonById(id: Int, dm: DisposableManager, successListener: (it: PokemonEntity) -> Unit, errorListener: () -> Unit) {
        PokemonByIdUseCase.searchPokemonById(id, dm, successListener) {
            errorListener()
        }
    }

    fun requestListPokemon(disposableManager: DisposableManager, successListener: (it: List<PokemonEntity>) -> Unit, errorListener: () -> Unit) {
        PokemonListUseCase.getAllPokemon(disposableManager, successListener) {
            errorListener()
        }
    }

}

