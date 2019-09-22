package com.test.networking

import com.test.apipoke.PokeIntegration
import com.test.apipoke.model.PokemonEntity
import com.test.core.view.DisposableManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PokemonListUseCase {

    private const val FIRST_OFF_SET = 0

    fun getAllPokemon(
        dm: DisposableManager,
        callbackSuccess: (it: List<PokemonEntity>) -> Unit,
        callbackError: (it: Throwable) -> Unit
    ) {

        val disposable = Observable
            .just(PokeIntegration)
            .subscribeOn(Schedulers.io())
            .map { it.requestListPokemon(FIRST_OFF_SET) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callbackSuccess::invoke, callbackError::invoke)

        dm.addDisposable(disposable)
    }
}