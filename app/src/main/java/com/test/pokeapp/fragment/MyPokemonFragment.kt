package com.test.pokeapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.pokeapp.R
import com.test.pokeapp.SearchListener

class MyPokemonFragment : Fragment(), SearchListener {
    companion object {
        fun newInstance() = MyPokemonFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_list_of_pokemon, container, false)
    }

    override fun onQueryTextSubmit(query: String) {

    }

    override fun useListDefault() {
    }
}