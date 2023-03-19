package com.example.departmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventsAdapter(private val list:ArrayList<Events>):RecyclerView.Adapter<EventsAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.events_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.eventsHeading.text = currentItem.Desc
        holder.eventsDesc.text = currentItem.Heading

    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val eventsHeading:TextView = itemView.findViewById(R.id.eventsHeading)
        val eventsDesc:TextView = itemView.findViewById(R.id.eventsDescription)
    }
}