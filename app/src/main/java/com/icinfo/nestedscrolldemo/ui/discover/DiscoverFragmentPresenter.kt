package com.icinfo.nestedscrolldemo.ui.discover

import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.entity.BannerEntity
import com.icinfo.nestedscrolldemo.http.HttpDefaultObserver
import com.icinfo.nestedscrolldemo.http.RetrofitFactory
import com.icinfo.nestedscrolldemo.http.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/


class DiscoverFragmentPresenter : DiscoverFragmentContract.Presenter {

    private lateinit var view: DiscoverFragmentContract.View

    override fun getImageList() {

        RetrofitHelper.getApiService().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : HttpDefaultObserver<MutableList<BannerEntity>>() {
                    override fun disposable(d: Disposable) {
                        addSubscribe(d)
                    }

                    override fun onSuccess(t: MutableList<BannerEntity>) {
                        view?.showBanner(t)
                    }

                    override fun onError(errorMsg: String) {
                        view?.onError(errorMsg)
                    }

                })
    }

    override fun loadData(pageNum: Int) {
        RetrofitHelper.getApiService()
                .getHomeList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : HttpDefaultObserver<ArticleEntity>() {
                    override fun disposable(d: Disposable) {
                        addSubscribe(d)
                    }

                    override fun onSuccess(t: ArticleEntity) {
                        if (pageNum == 0) {
                            t.datas?.let { loadTopList(it) }
                        } else{
                            t.datas?.let { view?.showList(it)}
                        }
                    }

                    override fun onError(errorMsg: String) {
                        view?.onError(errorMsg)
                    }

                })
    }

    private fun loadTopList(it: MutableList<ArticleEntity.DatasBean>) {
        TODO("Not yet implemented")
    }

    override fun setContractView(view: DiscoverFragmentContract.View) {
        this.view = view
    }

    override fun onStart() {
    }

    override fun onDestroy() {
        compositeDisposable?.clear()
    }

    private var compositeDisposable: CompositeDisposable? = null

    init {
        compositeDisposable = CompositeDisposable()
    }

    private fun addSubscribe(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }
}