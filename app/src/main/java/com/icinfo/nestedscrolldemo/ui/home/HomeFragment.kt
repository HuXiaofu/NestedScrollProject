package com.icinfo.nestedscrolldemo.ui.home

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.BaseFragment
import com.icinfo.nestedscrolldemo.ui.HomeFragmentPresenter
import com.icinfo.nestedscrolldemo.ui.home.model.IconTitleModel
import com.icinfo.nestedscrolldemo.ui.home.model.ShopModel
import com.icinfo.nestedscrolldemo.utils.GlideImageLoader
import com.icinfo.nestedscrolldemo.widget.decoration.HomeGridDecoration
import com.icinfo.nestedscrolldemo.widget.decoration.HomeLinearDecoration
import com.icinfo.nestedscrolldemo.widget.decoration.LinearDividerItemDecoration
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *@time：2020/12/1
 *@author:hugaojian
 **/
class HomeFragment : BaseFragment(), HomeFragmentContract.View {

    private lateinit var presenter: HomeFragmentContract.Presenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        presenter = HomeFragmentPresenter()
        presenter.setContractView(this)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    override fun addViewToBigModule(iconTitleModel: IconTitleModel) {
    }

    override fun setShopListData(shopModels: List<ShopModel>) {
    }

    private fun init() {
        initBanner()
        initLittleModuleRecyclerView()
        initShopsRecyclerView()
    }

    private fun initLittleModuleRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview_little_module.layoutManager = linearLayoutManager
        recyclerview_little_module.addItemDecoration(HomeLinearDecoration(12f))
        recyclerview_little_module.itemAnimator = DefaultItemAnimator()

        //判断context是否为空，如果不为空执行let中的代码
        context?.let {
            val shopAdapter = ShopAdapter(it, presenter.bigModuleDrawables())
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
            val littleModuleAdapter = LittleModuleAdapter(it, presenter.getIconTitleModels())
            recycler_view_shops.adapter = littleModuleAdapter
        }

    }

    private fun initBanner() {
        home_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(GlideImageLoader)
                .setImages(presenter.getBannerImages())
                .setBannerAnimation(Transformer.Default)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start()
    }
}