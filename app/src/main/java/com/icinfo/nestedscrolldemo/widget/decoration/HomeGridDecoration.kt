package com.icinfo.nestedscrolldemo.widget.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.icinfo.nestedscrolldemo.utils.DesityUtils

class HomeGridDecoration(private val space: Float) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = DesityUtils.dip2px(space)
    }
}
