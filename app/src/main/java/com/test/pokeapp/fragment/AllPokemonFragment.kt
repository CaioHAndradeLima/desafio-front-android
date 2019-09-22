package com.test.pokeapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.core.view.BaseFragment
import com.test.pokeapp.MainFragmentsContract
import com.test.pokeapp.R
import com.test.pokeapp.SearchListener
import com.test.pokeapp.fragment.adapter.PokemonAdapter
import com.test.pokeapp.presenter.MainPresenter

class AllPokemonFragment : BaseFragment(), SearchListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingView: View

    companion object {
        fun newInstance() = AllPokemonFragment()
    }

    override fun onQueryTextSubmit(query: String) {

    }

    override fun useListDefault() {
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_list_of_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        loadingView = view.findViewById(R.id.loading)
        requestListPokemon()
    }

    private fun requestListPokemon() {
        getMainPresenter().requestListPokemon(this, successListener = {
            loadingView.visibility = View.GONE
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = PokemonAdapter(it)
        }, errorListener = {
            context?.let {
                Toast.makeText(it, "Erro conexão", Toast.LENGTH_LONG).show()
            }

        })
    }

    protected fun getMainPresenter(): MainPresenter = (requireActivity() as MainFragmentsContract).getMainPresenter()
}