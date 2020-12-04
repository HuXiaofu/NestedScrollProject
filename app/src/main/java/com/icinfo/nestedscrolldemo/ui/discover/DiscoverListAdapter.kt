package com.icinfo.nestedscrolldemo.ui.discover

import android.content.Context
import android.graphics.Color
import android.graphics.Color.red
import android.text.Html
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.entity.Constants

class DiscoverListAdapter(private val t: MutableList<ArticleEntity.DatasBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context

    override fun getItemViewType(position: Int): Int {
        return t[position].getItemType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == Constants.ITEM_ARTICLE) {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_discover_article, parent, false)
        DiscoverArticle(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_discover_project, parent, false)
        DiscoverProject(view)
    }

    override fun getItemCount(): Int {
        return t.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = t[position]
        when (holder) {
            is DiscoverArticle -> {
                item?.apply {
                    if (type == 1) {
                        holder.tvTag.text = "置顶"
                        holder.tvTag.setTextColor(Color.RED)
                    } else {
                        holder.tvTag.text = ""
                    }
                    holder.tvAuthor.text = if (!TextUtils.isEmpty(author)) author else shareUser
                    holder.tvDate.text = niceDate
                    holder.tvTitle.text = Html.fromHtml(title)
                    holder.tvChapterName.text = superChapterName
                    holder.ivCollect.apply {
                        if (item.collect) {
                            setImageResource(R.mipmap.article_collect)
                        } else {
                            setImageResource(R.mipmap.article_un_collect)
                        }
                    }
                }
            }
            is DiscoverProject -> {
                item?.apply {
                    Glide.with(context).load(envelopePic).into(holder.ivTitle)
                    holder.tvTitle.text = title
                    holder.tvDes.text = desc
                    holder.tvNameData.text = "$niceDate | $author"
                    holder.ivCollect.apply {
                        if (item.collect) {
                            setImageResource(R.mipmap.article_collect)
                        } else {
                            setImageResource(R.mipmap.article_un_collect)
                        }
                    }
                }

            }
        }
    }

}
