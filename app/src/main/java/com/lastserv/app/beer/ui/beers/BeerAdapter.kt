package com.lastserv.app.beer.ui.beers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lastserv.app.beer.R
import com.lastserv.app.beer.ui.model.BeerViewModel
import javax.inject.Inject

class BeerAdapter @Inject constructor(): RecyclerView.Adapter<BeerAdapter.ViewHolder>() {

    var beerModels: List<BeerViewModel> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = beerModels[position]
        holder.nameText.text = beer.name
        holder.taglineText.text = beer.tagline

        Glide.with(holder.itemView.context)
                .load(beer.image_url)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.beerImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_beer, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return beerModels.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var beerImage: ImageView
        var nameText: TextView
        var taglineText: TextView

        init {
            beerImage = view.findViewById(R.id.image)
            nameText = view.findViewById(R.id.text_name)
            taglineText = view.findViewById(R.id.text_tagline)
        }
    }

}