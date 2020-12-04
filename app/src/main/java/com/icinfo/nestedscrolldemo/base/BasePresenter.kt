package com.icinfo.nestedscrolldemo.base

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
 interface BasePresenter<T> {

    /**
     * 将view传递给presenter
     */
    fun setContractView(view:T)
    fun onStart()
    fun onDestroy()
}