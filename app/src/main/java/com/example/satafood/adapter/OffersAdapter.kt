package com.example.satafood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satafood.R
import com.example.satafood.model.Cuisine
import com.example.satafood.model.Newoffer
import kotlinx.android.synthetic.main.offer_item.view.*


class OffersAdapter : RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    private var myOffers = emptyList<Newoffer>()
    private var myCuisine = ArrayList<String>()

    inner class OffersViewHolder (itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        return OffersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.offer_item,parent,false))
    }

    override fun getItemCount(): Int {
        return myOffers.size
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        for(item in myOffers){
            myCuisine.add(myOffers[position].cuisines[position].name)
        }

        Glide.with(holder.itemView)
            .load("http://satafood.codesroots.com:3000/"+myOffers[position].cover)
            .into(holder.itemView.offerImage)

        holder.itemView.offerName.text = myOffers[position].name
        holder.itemView.cuisinesText.text = myCuisine[position].plus("-"+myCuisine[position+1]).plus("-"+myCuisine[position+2])

    }

    fun setOfferData(myOffers: List<Newoffer>){
        this.myOffers = myOffers
        notifyDataSetChanged()
    }

}