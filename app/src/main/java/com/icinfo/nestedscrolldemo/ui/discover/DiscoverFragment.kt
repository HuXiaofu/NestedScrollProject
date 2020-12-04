package com.icinfo.nestedscrolldemo.ui.discover

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.BaseFragment
import com.icinfo.nestedscrolldemo.entity.BannerEntity
import com.icinfo.nestedscrolldemo.utils.GlideImageLoader
import com.icinfo.nestedscrolldemo.widget.decoration.HomeGridDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_discover.*

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/
class DiscoverFragment : BaseFragment() ,DiscoverFragmentContract.View{

    private val presenter = DiscoverFragmentPresenter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_discover, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val mainActivity = activity as MainActivity
            mainActivity.setHideStatusBar(false)
        }
        init()

    }

    private fun init() {
        presenter.setContractView(this)
        initBanner()
        discover_news_flipper.setData(listOf("夏日炎炎，第一波福利还有30秒到达战场", "新用户立领1000元优惠券"))
    }


    private fun initBanner() {
        presenter.getImageList()
        presenter.loadData(1)
    }

    override fun showBanner(t: MutableList<BannerEntity>) {
         var datas= mutableListOf<String>()
        repeat(t.size){
            t[it].imagePath?.let { it1 -> datas.add(it1) }
        }
        discover_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(GlideImageLoader)
                .setImages(datas)
                .setBannerAnimation(Transformer.Default)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start()
    }

    @SuppressLint("WrongConstant")
    override fun showList(t: MutableList<ArticleEntity.DatasBean>) {
        val vertical = LinearLayoutManager.VERTICAL
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = vertical
        discover_recyclerview.layoutManager=linearLayoutManager
        discover_recyclerview.addItemDecoration(HomeGridDecoration(10f))
        val discoverListAdapter=DiscoverListAdapter(t)
        discover_recyclerview.adapter=discoverListAdapter
    }

    override fun onError(errorMsg: String) {
        TODO("Not yet implemented")
    }
}