package com.icinfo.nestedscrolldemo.ui.discover

import com.icinfo.nestedscrolldemo.base.BasePresenter
import com.icinfo.nestedscrolldemo.base.IBasePresenter
import com.icinfo.nestedscrolldemo.base.IBaseView
import com.icinfo.nestedscrolldemo.entity.BannerEntity
import io.reactivex.disposables.CompositeDisposable

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/
interface DiscoverFragmentContract {

    interface View:IBaseView{
        fun showBanner(t: MutableList<BannerEntity>)
        fun showList(t: MutableList<ArticleEntity.DatasBean>)

    }
    interface Presenter<T>:IBasePresenter<View>{
        fun getImageList()
        fun loadData(pageNum:Int)
    }
}