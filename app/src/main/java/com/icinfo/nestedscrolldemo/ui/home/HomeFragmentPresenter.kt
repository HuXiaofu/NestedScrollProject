package com.icinfo.nestedscrolldemo.ui.home

import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.ui.home.HomeFragmentContract
import com.icinfo.nestedscrolldemo.ui.home.model.IconTitleModel
import kotlinx.android.synthetic.main.include_main_tab.view.*

/**
 *@time：2020/12/1
 *@author:hugaojian
 **/
public class HomeFragmentPresenter : HomeFragmentContract.Presenter {

    private lateinit var mFragment: HomeFragmentContract.View
    override fun getBannerImages(): List<Int> {
        return listOf(
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3,
                R.drawable.banner4,
                R.drawable.banner5,
                R.drawable.banner6
        )
    }

    private val bigModuleDrawables= intArrayOf (
            R.mipmap.homepage_icon_light_food_b,
            R.mipmap.homepage_icon_light_movie_b,
            R.mipmap.homepage_icon_light_hotel_b,
            R.mipmap.homepage_icon_light_amusement_b,
            R.mipmap.homepage_icon_light_takeout_b
    )


    override fun getIconTitleModels(): List<IconTitleModel> {
        return mutableListOf(
                IconTitleModel(R.mipmap.homepage_icon_light_ktv_s, "KTV"),
                IconTitleModel(R.mipmap.homepage_icon_light_toursaround_s, "周边游"),
                IconTitleModel(R.mipmap.homepage_icon_light_transportation_s, "机票/火车票"),
                IconTitleModel(R.mipmap.homepage_icon_light_beauty_s, "丽人/美发"),
                IconTitleModel(R.mipmap.homepage_icon_light_travel_s, "旅游/出行"),
                IconTitleModel(R.mipmap.homepage_icon_light_fitness_s, "跑腿/代购"),
                IconTitleModel(R.mipmap.homepage_icon_light_amusement_s, "景点/门票"),
                IconTitleModel(R.mipmap.homepage_icon_light_bath_s, "温泉"),
                IconTitleModel(R.mipmap.homepage_icon_light_more_s, "全部分类"))
    }

    override fun bigModuleDrawables(): IntArray {
        return bigModuleDrawables
    }

    override fun setContractView(view: HomeFragmentContract.View) {
        mFragment = view
    }

    override fun onStart() {
    }

    private fun initBigModule() {
        for (i in 0..5){

        }
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}