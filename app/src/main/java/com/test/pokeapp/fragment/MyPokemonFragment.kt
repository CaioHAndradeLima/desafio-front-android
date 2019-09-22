package com.test.pokeapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.pokeapp.R
import com.test.pokeapp.SearchListener

class MyPokemonFragment : Fragment(), SearchListener {
    companion object {
        fun newInstance() = MyPokemonFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //recyclerView.adapter =
    }

    override fun onQueryTextSubmit(query: String) {

    }

    override fun useListDefault() {
    }
}