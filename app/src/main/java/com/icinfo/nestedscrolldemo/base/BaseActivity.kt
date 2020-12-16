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
abstract class BaseActivity<P : IBasePresenter<*>> : AppCompatActivity() {

    protected var presenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setHideStatusBar(true)
        val layoutId = getLayoutId()
        if (layoutId != 0) {
            setContentView(layoutId)
        }
        presenter = createPresenter()
        presenter?.let { lifecycle.addObserver(it) }
        setRxJavaErrorHandler()
        init(savedInstanceState)
    }

    protected abstract fun init(savedInstanceState: Bundle?)

    protected abstract fun createPresenter(): P?

    protected abstract fun getLayoutId(): Int

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

    private fun setRxJavaErrorHandler() {
        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }
    }
}