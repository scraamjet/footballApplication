package com.example.footballapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter (
    private var list: List<TeamDTO>,
    private val itemClick: (id:Int)->Unit,

    ): RecyclerView.Adapter<TeamHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder =
        TeamHolder.getInstance(parent,itemClick)

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataList(newList: List<TeamDTO>){
        list = newList
        notifyDataSetChanged()
    }
}