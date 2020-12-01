package com.icinfo.nestedscrolldemo.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icinfo.nestedscrolldemo.R

public class ShopAdapter(private val context: Context, private val bigModuleDrawables: IntArray) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    private val bigMudoleTitles = arrayOf(
            "美食",
            "电影/演出",
            "酒店住宿",
            "休闲娱乐",
            "外卖"
    )


    class ShopViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.iv_icon_title)
        var title: TextView = view.findViewById(R.id.tv_icon_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(LayoutInflater.from(context).inflate(R.layout.view_header_title_small, parent, false
        ))
    }

    override fun getItemCount(): Int {
        return bigModuleDrawables.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.image.setImageResource(bigModuleDrawables[position])
        holder.title.text = bigMudoleTitles[position]
    }
}
