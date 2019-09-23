package com.test.networking.localdatabase

import android.content.Context
import com.gizmin.localdatabase.model.PokemonLocalEntity
import com.gizmin.localdatabase.provider.AppDataBaseProvider.provideDatabase
import com.test.core.view.DisposableManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PokemonCapturedLocalUseCase {

    fun searchCapturedPokemon(
        context: Context,
        dm: DisposableManager?,
        callbackSuccess: (it: List<PokemonLocalEntity>) -> Unit,
        callbackError: (it: Throwable) -> Unit
    ) {

        val disposable = Observable
            .just(provideDatabase(context))
            .observeOn(Schedulers.io())
            .map { it.pokemonDao().fetchPokemon() }
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(callbackSuccess::invoke, callbackError::invoke)

        dm?.addDisposable(disposable)
    }
}