package com.example.satafood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satafood.R
import com.example.satafood.model.*
import com.example.satafood.util.Constants.Companion.BASE_URL
import kotlinx.android.synthetic.main.category_item.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myCategories = emptyList<Category>()

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false))
    }

    override fun getItemCount(): Int {
        return myCategories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("http://satafood.codesroots.com:3000/"+myCategories[position].photo)
            .into(holder.itemView.category_image)
        holder.itemView.category_title.text = myCategories[position].name
    }
    fun setData(myCategories: List<Category>){
        this.myCategories = myCategories
        notifyDataSetChanged()
    }
}