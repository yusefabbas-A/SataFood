package com.example.satafood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satafood.R
import com.example.satafood.model.Slider
import com.example.satafood.util.Constants.Companion.BASE_URL
import kotlinx.android.synthetic.main.slider_item.view.*

class SlidAdapter : RecyclerView.Adapter<SlidAdapter.SlidViewHolder>() {
    private var mySlides = emptyList<Slider>()

    inner class SlidViewHolder (itemView : View):RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return mySlides.size
    }

    override fun onBindViewHolder(holder: SlidViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("http://satafood.codesroots.com:3000/"+mySlides[position].photo)
            .into(holder.itemView.sliderImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlidViewHolder {
        return SlidViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slider_item,parent,false))
    }

    fun setSlidData(mySlides: List<Slider>){
        this.mySlides = mySlides
        notifyDataSetChanged()
    }
}