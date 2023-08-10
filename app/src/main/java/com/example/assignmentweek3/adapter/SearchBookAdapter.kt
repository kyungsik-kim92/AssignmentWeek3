package com.example.assignmentweek3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentweek3.databinding.ItemBookBinding
import com.example.assignmentweek3.model.Document

class SearchBookAdapter : RecyclerView.Adapter<SearchBookViewHolder>() {

    private val documents = mutableListOf<Document>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(binding)

    }

    override fun getItemCount(): Int = documents.size

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(documents[position])
    }
}