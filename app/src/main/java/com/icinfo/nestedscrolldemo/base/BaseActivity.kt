package com.icinfo.nestedscrolldemo.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.plugins.RxJavaPlugins

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setHideStatusBar(true)
        setRxJavaErrorHandler()
    }

    @SuppressLint("InlinedApi")
    fun setHideStatusBar(isHideStatus: Boolean) {
        when (isHideStatus) {
            true -> {
                window.addFlags(FLAG_TRANSLUCENT_STATUS)
                val view = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.decorView.systemUiVisibility = view
            }
            false -> {
                window.clearFlags(FLAG_TRANSLUCENT_STATUS)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

    }
    private fun setRxJavaErrorHandler(){
        RxJavaPlugins.setErrorHandler{
            it.printStackTrace()
        }
    }
}