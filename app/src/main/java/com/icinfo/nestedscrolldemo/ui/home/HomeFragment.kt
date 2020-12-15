package com.icinfo.nestedscrolldemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.AppLazyFragment
import com.icinfo.nestedscrolldemo.base.BaseFragment
import com.icinfo.nestedscrolldemo.ui.home.model.IconTitleModel
import com.icinfo.nestedscrolldemo.ui.home.model.ShopModel
import com.icinfo.nestedscrolldemo.utils.GlideImageLoader
import com.icinfo.nestedscrolldemo.widget.decoration.HomeGridDecoration
import com.icinfo.nestedscrolldemo.widget.decoration.HomeLinearDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *@time：2020/12/1
 *@author:hugaojian
 **/
class HomeFragment : AppLazyFragment<HomeFragmentContract.Presenter<HomeFragmentContract.View>>(), HomeFragmentContract.View {

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        initBanner()
        initLittleModuleRecyclerView()
        initShopsRecyclerView()
    }

    override fun addViewToBigModule(iconTitleModel: IconTitleModel) {
    }

    override fun setShopListData(shopModels: List<ShopModel>) {
    }

    override fun onError(error: String) {

    }


    private fun initLittleModuleRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview_little_module.layoutManager = linearLayoutManager
        recyclerview_little_module.addItemDecoration(HomeLinearDecoration(12f))
        recyclerview_little_module.itemAnimator = DefaultItemAnimator()

        //判断context是否为空，如果不为空执行let中的代码
        context?.let {
            val shopAdapter = presenter?.bigModuleDrawables()?.let { it1 -> ShopAdapter(it, it1) }
            recyclerview_little_module.adapter = shopAdapter
        }
    }

    private fun initShopsRecyclerView() {
        val gridLayoutManager = GridLayoutManager(activity, 5)
        recycler_view_shops.layoutManager = gridLayoutManager
        recycler_view_shops.addItemDecoration(HomeGridDecoration(12f))
        recycler_view_shops.itemAnimator = DefaultItemAnimator()

        //判断context是否为空，如果不为空执行let中的代码
        context?.let {
            val littleModuleAdapter = presenter?.getIconTitleModels()?.let { it1 -> LittleModuleAdapter(it, it1) }
            recycler_view_shops.adapter = littleModuleAdapter
        }

    }

    private fun initBanner() {
        home_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(GlideImageLoader)
                .setImages(presenter?.getBannerImages())
                .setBannerAnimation(Transformer.Default)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start()
    }

    override fun lazyInit() {
        if (activity != null) {
            activity.let {
                it as MainActivity
                it.setHideStatusBar(true)
            }
        }
    }

    override fun createPresenter(): HomeFragmentContract.Presenter<HomeFragmentContract.View>? {
        return HomeFragmentPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }
}