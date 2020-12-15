package com.icinfo.nestedscrolldemo.ui.mine

import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.BaseFragment
import com.icinfo.nestedscrolldemo.base.LazyFragment

/**
 *@time：2020/12/15
 *@author:hugaojian
 **/
class MineFragment : LazyFragment<MineFragmentContract.Presenter<MineFragmentContract.View>>() {

    override fun lazyInit() {
        activity?.let {
            it as MainActivity
            it.setHideStatusBar(true)
        }
    }

    override fun createPresenter(): MineFragmentContract.Presenter<MineFragmentContract.View>? {
        return null
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }
}