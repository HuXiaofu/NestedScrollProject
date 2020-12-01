package com.icinfo.nestedscrolldemo.ui.home

import com.icinfo.nestedscrolldemo.base.BasePresenter
import com.icinfo.nestedscrolldemo.ui.home.model.IconTitleModel
import com.icinfo.nestedscrolldemo.ui.home.model.ShopModel

/**
 *@time：2020/12/1
 *@author:hugaojian
 **/
public interface HomeFragmentContract {
    interface View{
        fun addViewToBigModule(iconTitleModel: IconTitleModel)
        fun setShopListData(shopModels:List<ShopModel>)
    }
    interface Presenter :BasePresenter<View>{
        fun getBannerImages():List<Int>
        fun getIconTitleModels():List<IconTitleModel>
        fun bigModuleDrawables():IntArray

    }
}