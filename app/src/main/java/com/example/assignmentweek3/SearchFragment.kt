package com.example.assignmentweek3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentweek3.adapter.SearchBookAdapter
import com.example.assignmentweek3.databinding.FragmentSearchBinding
import com.example.assignmentweek3.viewmodel.BookSearchViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private lateinit var bookSearchViewModel: BookSearchViewModel
    private val searchBookAdapter: SearchBookAdapter = SearchBookAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root



    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSearchResult.adapter = searchBookAdapter

        bookSearchViewModel = (activity as MainActivity).bookSearchViewModel

        binding.btnSearch.setOnClickListener {
            bookSearchViewModel.searchBooks(binding.etSearch.text.toString())

        }
        bookSearchViewModel.searchResultLiveData.observe(viewLifecycleOwner) {
            searchBookAdapter.addAll(it)
        }




    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}