package com.test.pokeapp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.test.pokeapp.fragment.AllPokemonFragment
import com.test.pokeapp.fragment.MyPokemonFragment

class MainPagerAdapter(private val activity: AppCompatActivity) :
    FragmentPagerAdapter(activity.supportFragmentManager) {

    companion object {
        const val TOTAL_PAGES = 2
        const val POSITION_MY_POKEMON_FRAGMENT = 0
        const val POSITION_ALL_POKEMON_FRAGMENT = 1
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            POSITION_MY_POKEMON_FRAGMENT -> MyPokemonFragment.newInstance()
            else -> AllPokemonFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            POSITION_MY_POKEMON_FRAGMENT -> activity.getString(R.string.tab_my_pokemon)
            else -> activity.getString(R.string.tab_all_pokemon)
        }
    }

    override fun getCount(): Int {
        return TOTAL_PAGES
    }
}
