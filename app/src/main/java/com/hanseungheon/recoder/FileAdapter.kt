package com.hanseungheon.recoder

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileAdapter (var items:MutableList<Record>):RecyclerView.Adapter<FileAdapter.ItemViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context=parent.context
        val view=LayoutInflater.from(context).inflate(R.layout.adapter_file, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.fileName.text = items[position].file.split("/").last()
        holder.seekBar.max = items[position].length
        holder.alltime.text = String.format("%02d:%02d", items[position].length/60, items[position].length%60 )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val fileName: TextView = itemView.findViewById(R.id.fileName)
        val alltime: TextView = itemView.findViewById(R.id.alltime)
        val time : TextView = itemView.findViewById(R.id.time)
        val seekBar: SeekBar = itemView.findViewById(R.id.seekbar)
        val play : ImageButton = itemView.findViewById(R.id.play)
        val delete : ImageButton = itemView.findViewById(R.id.delete)
    }
}