package com.test.pokeapp.fragment

import androidx.fragment.app.Fragment
import com.test.pokeapp.SearchListener

class AllPokemonFragment: Fragment(), SearchListener {

    companion object {
        fun newInstance() = AllPokemonFragment()
    }

    override fun onQueryTextSubmit(query: String) {

    }

    override fun useListDefault() {
    }
}