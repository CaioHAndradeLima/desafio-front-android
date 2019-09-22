package com.test.pokeapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.viewpager.widget.ViewPager
import com.test.core.view.BaseActivity
import com.test.core.extension.getFragment
import com.test.core.extension.hideSoftKeyboard
import com.test.pokeapp.MainPagerAdapter.Companion.POSITION_MY_POKEMON_FRAGMENT
import com.test.pokeapp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
    ViewPager.OnPageChangeListener,
    MainFragmentsContract
{
    private lateinit var searchView: SearchView
    private val presenter by lazy { MainPresenter() }

    private var lastPositionViewPager = POSITION_MY_POKEMON_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tablayout.setupWithViewPager(
            viewpager
        )
        viewpager.adapter = MainPagerAdapter(this)
        viewpager.addOnPageChangeListener(this)
    }


    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        super.onPrepareOptionsMenu(menu)
        val searchViewMenuItem = menu.findItem(R.id.search)
        searchView = searchViewMenuItem.actionView as SearchView
        searchView.queryHint = getString(R.string.search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                (supportFragmentManager.getFragment(viewpager)
                        as SearchListener).onQueryTextSubmit(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })

        searchView.setOnCloseListener {
            closeSearchBar()
            false
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onBackPressed() {
        if (!searchView.isIconified) {
            searchView.isIconified = true
            closeSearchBar()
        } else {
            super.onBackPressed()
        }
    }

    private fun closeSearchBar() {
        hideSoftKeyboard()
        (supportFragmentManager.getFragment(viewpager, lastPositionViewPager)
                as SearchListener).useListDefault()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        if (searchView.isIconified) {
            lastPositionViewPager = position
            return
        }

        searchView.setQuery("", false)
        searchView.isIconified = true
        closeSearchBar()
        lastPositionViewPager = position
    }

    override fun getMainPresenter(): MainPresenter = presenter

}

interface MainFragmentsContract {

    fun getMainPresenter() : MainPresenter

}