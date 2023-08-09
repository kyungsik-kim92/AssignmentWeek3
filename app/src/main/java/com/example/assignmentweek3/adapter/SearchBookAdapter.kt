package com.example.assignmentweek3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentweek3.R
import com.example.assignmentweek3.databinding.ItemBookBinding
import com.example.assignmentweek3.model.Document

class SearchBookAdapter : RecyclerView.Adapter<SearchBookViewHolder>() {

    lateinit var itemBookBinding: ItemBookBinding

    private val documents = mutableListOf<Document>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        itemBookBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book,
            parent,
            false
        )
        return SearchBookViewHolder(itemBookBinding)

    }

    override fun getItemCount(): Int = documents.size

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        holder.bind(documents[position])
    }
}