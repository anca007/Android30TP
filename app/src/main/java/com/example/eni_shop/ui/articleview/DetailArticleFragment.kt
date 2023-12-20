package com.example.eni_shop.ui.articleview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.eni_shop.databinding.FragmentDetailArticleBinding


class DetailArticleFragment : Fragment() {

    lateinit var binding: FragmentDetailArticleBinding
    val args: DetailArticleFragmentArgs by navArgs()
    val vm: DetailArticleViewModel by viewModels { DetailArticleViewModel.Factory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailArticleBinding.inflate(layoutInflater, container, false)
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_article , container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article
        binding.article = article

        binding.checkFav.setOnClickListener {

            if (binding.checkFav.isChecked) {

                vm.addArticleToFav(article).observe(viewLifecycleOwner) {
                    Toast.makeText(
                        view.context,
                        "L'article a été ajouté à vos favoris !",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            } else {
                vm.deleteArticleFav(article)
                Toast.makeText(
                    view.context,
                    "L'article a été retiré de vos favoris !",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }




        binding.tvArticleTitle.setOnClickListener {

            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=eni-shop+" + article.titre)
            ).also {
                startActivity(it)
            }


        }


    }

}