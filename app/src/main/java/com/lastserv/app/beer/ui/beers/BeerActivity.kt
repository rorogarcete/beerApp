package com.lastserv.app.beer.ui.beers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.lastserv.app.beer.R
import com.lastserv.app.beer.presentation.beers.BeerContract
import com.lastserv.app.beer.presentation.model.BeerView
import com.lastserv.app.beer.ui.mapper.BeerMapper
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_beer.*
import javax.inject.Inject

class BeerActivity : AppCompatActivity(), BeerContract.View {

    @Inject lateinit var beerPresenter: BeerContract.Presenter
    @Inject lateinit var beerAdapter: BeerAdapter
    @Inject lateinit var mapper: BeerMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer)
        AndroidInjection.inject(this)
        setupRecycler()
    }

    override fun onStart() {
        super.onStart()
        beerPresenter.start()
    }

    override fun setPresenter(presenter: BeerContract.Presenter) {
        beerPresenter = presenter
    }

    private fun setupRecycler() {
        recycler_beer.layoutManager = LinearLayoutManager(this)
        recycler_beer.adapter = beerAdapter
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showBeers(beers: List<BeerView>) {
        beerAdapter.beerModels = beers.map { mapper.mapToViewModel(it) }
        beerAdapter.notifyDataSetChanged()
        recycler_beer.visibility = View.VISIBLE
    }

    override fun hideBeers() {
        recycler_beer.visibility = View.GONE
    }

    override fun showErrorState() {}

    override fun hideErrorState() {}

    override fun showEmptyState() {}

    override fun hideEmptyState() {}

}