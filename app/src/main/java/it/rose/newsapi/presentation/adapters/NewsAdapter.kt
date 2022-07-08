package it.rose.newsapi.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.rose.newsapi.R
import it.rose.newsapi.data.pojo.Article
import kotlinx.android.synthetic.main.news_layout.view.*


class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context: Context
    var list = emptyList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.textView_titleItem.text = list[position].title
        holder.itemView.textView_authorItem.text = list[position].author
        Glide.with(context)
            .load(list[position].urlToImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.imageViewLogo)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NewsHolder(view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setList1")
    fun setList(newsList: List<Article>) {
        list = newsList
        notifyDataSetChanged()
    }
}