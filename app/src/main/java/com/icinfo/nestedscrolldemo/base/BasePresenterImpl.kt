package com.icinfo.nestedscrolldemo.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *@time：2020/12/3
 *@author:hugaojian
 **/
open class BasePresenterImpl<V:BaseView<V> >:BasePresenter<V>{
    private var compositeDisposable: CompositeDisposable?=null

    init {
        compositeDisposable= CompositeDisposable()
    }

    override fun setContractView(view: V) {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
    protected fun addSubscribe(disposable: Disposable){
        compositeDisposable?.add(disposable)
    }
}