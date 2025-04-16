package com.example.tugas2pm

import android.content.ClipData.Item
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(private val namaList : ArrayList<ItemData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    var onItemClick : ((ItemData)-> Unit)? = null
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val gambar : ImageView = itemView.findViewById(R.id.imageView3)
        val nama : TextView = itemView.findViewById(R.id.imageTitle)
//        val price : TextView = itemView.findViewById(R.id.txtView2)
//        val desc : TextView = itemView.findViewById(R.id.imageDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topUp = namaList[position]
        holder.gambar.setImageResource(topUp.gambar)
        holder.nama.text = topUp.nama

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(topUp)
        }
    }
}