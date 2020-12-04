package com.icinfo.nestedscrolldemo.ui.discover

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icinfo.nestedscrolldemo.R

/**
 *@time：2020/12/3
 *@author:hugaojian
 **/
sealed class DiscoverListViewHolder(view: View) :RecyclerView.ViewHolder(view)

class DiscoverArticle(view: View):DiscoverListViewHolder(view){
    val tvTag: TextView = view.findViewById(R.id.tvTag)
    val tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
    val tvDate: TextView = view.findViewById(R.id.tvDate)
    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val tvChapterName: TextView = view.findViewById(R.id.tvChapterName)
    val ivCollect: ImageView = view.findViewById(R.id.ivCollect)
}

class DiscoverProject(view: View):DiscoverListViewHolder(view){

    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val tvDes: TextView = view.findViewById(R.id.tvDes)
    val tvNameData: TextView = view.findViewById(R.id.tvNameData)
    val ivCollect: ImageView = view.findViewById(R.id.ivCollect)
    val ivTitle: ImageView = view.findViewById(R.id.ivTitle)
}