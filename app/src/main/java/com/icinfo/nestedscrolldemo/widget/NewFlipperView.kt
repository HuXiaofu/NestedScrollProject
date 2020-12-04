package com.icinfo.nestedscrolldemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.ViewFlipper
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.utils.DesityUtils
import kotlinx.android.synthetic.main.news_filpper.view.*

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/
class NewFlipperView : FrameLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private var viewFlipper: ViewFlipper

    constructor(context: Context, attributeSet: AttributeSet?, def: Int) : super(context, attributeSet, def) {
        val rootView = View.inflate(context, R.layout.news_filpper, null)
        viewFlipper = rootView.findViewById<ViewFlipper>(R.id.news_flipper)
        viewFlipper.setInAnimation(context, R.anim.news_bottom_in)
        viewFlipper.setInAnimation(context, R.anim.news_bottom_out)
        addView(rootView)
    }

    fun setData(data: List<String>) {
        for (text in data) {
            viewFlipper.addView(buildViewsView(text))
        }
        viewFlipper.startFlipping()
    }

    private fun buildViewsView(text: String): View? {
        val textView = TextView(context)
        textView.text = text
        textView.textSize = DesityUtils.dip2sp(30)
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.gravity=Gravity.CENTER_VERTICAL
        return textView
    }
}