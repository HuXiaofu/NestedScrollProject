package com.icinfo.nestedscrolldemo.ui.discover

import com.icinfo.nestedscrolldemo.base.BasePresenter
import com.icinfo.nestedscrolldemo.entity.BannerEntity
import io.reactivex.disposables.CompositeDisposable

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/
interface DiscoverFragmentContract {

    interface View{
        fun showBanner(t: MutableList<BannerEntity>)
        fun showList(t: MutableList<ArticleEntity.DatasBean>)
        fun onError(errorMsg: String)

    }
    interface Presenter:BasePresenter<View>{
        fun getImageList()
        fun loadData(pageNum:Int)
    }
}