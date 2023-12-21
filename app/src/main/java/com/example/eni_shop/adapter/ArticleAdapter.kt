package com.example.eni_shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.TemplateArticleLineBinding

class ArticleAdapter(var articleList: List<Article>, val listener: (article: Article) -> Unit) :
    Adapter<ArticleAdapter.ArticleVH>() {
    class ArticleVH(val binding: TemplateArticleLineBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = TemplateArticleLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ArticleVH(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        holder.binding.article = articleList[position]
        holder.itemView.setOnClickListener {
            listener.invoke(articleList[position])
        }
    }

}