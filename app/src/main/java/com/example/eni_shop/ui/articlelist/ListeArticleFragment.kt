package com.example.eni_shop.ui.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eni_shop.adapter.ArticleAdapter
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.FragmentListeArticleBinding

class ListeArticleFragment : Fragment() {

    lateinit var binding: FragmentListeArticleBinding
    val vm: ListeArticleViewModel by viewModels { ListeArticleViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListeArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getArticleList().observe(viewLifecycleOwner) { articles ->
            displayArticleList(articles)
        }

        binding.buttonFav.setOnClickListener {
            vm.getArticlesFav().observe(viewLifecycleOwner) {
                displayArticleList(it)
            }
        }
    }

    private fun displayArticleList(articles: List<Article>) {

        val recycler = binding.recycler
        recycler.adapter = ArticleAdapter(articles) {
            val direction = ListeArticleFragmentDirections.actionListToDetailArticle(it)
            Navigation.findNavController(requireView()).navigate(direction)
        }
        recycler.layoutManager = LinearLayoutManager(context)
    }

}


