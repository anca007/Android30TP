package com.example.eni_shop.ui.articlelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.FragmentListeArticleBinding
import com.example.eni_shop.repository.ArticleRepository

class ListeArticleFragment : Fragment() {

    lateinit var binding: FragmentListeArticleBinding
    val vm: ListeArticleViewModel by viewModels { ListeArticleViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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

        binding.btnToDetail.setOnClickListener {

            val direction =
                ListeArticleFragmentDirections.actionListToDetailArticle(
                    vm.getRandomArticle()
                )
            Navigation.findNavController(view).navigate(direction)
        }

    }

    private fun displayArticleList(articles: List<Article>) {
        var titles = ""

        articles?.forEach {
            titles += it.titre + "\n"
        }.also {
            binding.tvArticles.text = titles
        }


    }

}


