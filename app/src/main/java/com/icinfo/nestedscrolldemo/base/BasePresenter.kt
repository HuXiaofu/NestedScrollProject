package com.icinfo.nestedscrolldemo.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
open class BasePresenter<V : IBaseView>(view: V) : IBasePresenter<V> {

    protected var view: V = view
    private var compositeDisposable: CompositeDisposable? = null

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onPause() {

    }

    override fun onDestroy() {
        compositeDisposable?.clear()
    }

    protected fun addSubscribe(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }


}