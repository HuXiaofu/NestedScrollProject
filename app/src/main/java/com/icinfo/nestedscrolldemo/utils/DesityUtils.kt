package com.icinfo.nestedscrolldemo.utils

import android.content.res.Resources
import android.util.TypedValue
import com.bumptech.glide.load.engine.Resource

object DesityUtils {

     fun dip2px(dpValue:Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue*scale+0.5f).toInt()
    }

    fun dip2sp(dp: Int): Float {
        val scale=Resources.getSystem().displayMetrics.scaledDensity
        return dp/scale
    }
}
