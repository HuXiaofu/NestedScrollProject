package com.icinfo.nestedscrolldemo.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.ui.home.model.IconTitleModel

public class LittleModuleAdapter(private val context: Context, private val lists: List<IconTitleModel>) : RecyclerView.Adapter<LittleModuleAdapter.LittleViewHolder>() {


    class LittleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.iv_icon_title)
        var title: TextView = view.findViewById(R.id.tv_icon_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LittleViewHolder {
        return LittleViewHolder(LayoutInflater.from(context).inflate(R.layout.view_icon_title_small, parent, false))
    }

    override fun getItemCount(): Int {
        return lists?.size
    }

    override fun onBindViewHolder(holder: LittleViewHolder, position: Int) {
        holder.image.setImageResource(lists[position].iconResure)
        holder.title.text = lists[position].title
    }
}
