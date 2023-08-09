package com.example.assignmentweek3.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentweek3.databinding.ItemBookBinding
import com.example.assignmentweek3.model.Document

class SearchBookViewHolder(private val binding: ItemBookBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Document) {

        Glide.with(itemView).load(item.thumbnail).into(binding.image)

        binding.title.text = item.title
    }
}
