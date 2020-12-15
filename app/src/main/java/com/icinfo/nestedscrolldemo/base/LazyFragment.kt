package com.icinfo.nestedscrolldemo.base

import android.os.Bundle

/**
 *@time：2020/12/4
 *@author:hugaojian
 **/
abstract class LazyFragment<P : IBasePresenter<*>> : BaseFragment<P>() {
    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }

    override fun init(savedInstanceState: Bundle?) {

    }
    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()
}