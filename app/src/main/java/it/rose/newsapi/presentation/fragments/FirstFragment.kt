package it.rose.newsapi.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import it.rose.newsapi.databinding.FragmentFirstBinding
import it.rose.newsapi.domain.NewsViewModel
import it.rose.newsapi.presentation.adapters.NewsAdapter

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        recyclerView = binding.recyclerViewNews
        adapter = NewsAdapter(this)
        recyclerView.adapter = adapter
        viewModel.getNewsModel()
        viewModel.newsModelList.observe(viewLifecycleOwner, { list ->
            adapter.setList(list.body()!!.articles)
        })
    }
}