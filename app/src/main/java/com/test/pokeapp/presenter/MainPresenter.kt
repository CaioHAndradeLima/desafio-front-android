package com.test.pokeapp.presenter

import com.test.apipoke.model.PokemonEntity
import com.test.core.view.DisposableManager
import com.test.networking.PokemonByIdUseCase
import com.test.networking.remotedatabase.PokemonListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val FIRST_OFF_SET = 0

class MainPresenter {


    fun requestPokemonById(
        id: Int,
        dm: DisposableManager,
        successListener: (it: PokemonEntity) -> Unit,
        errorListener: () -> Unit
    ) {
        val disposable = PokemonByIdUseCase
            .searchPokemonById()
            .map { it(id) }
            .subscribe(successListener::invoke) {
                errorListener()
            }

        dm.addDisposable(disposable)
    }

    fun requestListPokemon(
        disposableManager: DisposableManager,
        successListener: (it: List<PokemonEntity>) -> Unit,
        errorListener: () -> Unit
    ) {
        val disposable = PokemonListUseCase
            .getAllPokemon()
            .subscribeOn(Schedulers.io())
            .map { it(FIRST_OFF_SET) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(successListener::invoke) {
                errorListener()
            }

        disposableManager.addDisposable(disposable)
    }

}

