package com.example.departmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FacultyMemberAdapter(private val list:ArrayList<FacultyMember>):RecyclerView.Adapter<FacultyMemberAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faculty_member_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        Picasso.get().load(currentItem.Image).into(holder.facultyImageView)
        holder.facultyName.text = currentItem.Name
        holder.facultyPost.text = currentItem.Post
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val facultyImageView:ImageView = itemView.findViewById(R.id.facultyImageView)
        val facultyName:TextView = itemView.findViewById(R.id.facultyName)
        val facultyPost:TextView = itemView.findViewById(R.id.facultyPost)
    }
}