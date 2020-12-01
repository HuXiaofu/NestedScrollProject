package com.icinfo.nestedscrolldemo.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.BaseFragment
import kotlinx.android.synthetic.main.include_main_tab.view.*

/**
 *@time：2020/11/30
 *@author:hugaojian
 **/
class CustomBottomTabWidget: LinearLayout, View.OnClickListener {

    private lateinit var mFragmentManager: FragmentManager
    private lateinit var mFragmentList: List<BaseFragment>
    private lateinit var mAdapter: TabPagerAdapter

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    private fun init() {
        View.inflate(context, R.layout.include_main_tab, this)
        selectTab(MenuTab.HOME)

        ll_menu_home.setOnClickListener(this)
        ll_menu_nearby.setOnClickListener(this)
        ll_menu_order.setOnClickListener(this)
        ll_menu_discover.setOnClickListener(this)
        ll_menu_mine.setOnClickListener(this)
    }

    public fun init(fm: FragmentManager, fragmentList: List<BaseFragment>) {
        mFragmentManager = fm
        mFragmentList = fragmentList
        initViewPager()
    }

    private fun initViewPager() {
        mAdapter = TabPagerAdapter(mFragmentManager, mFragmentList)
        vp_tab.adapter = mAdapter
        vp_tab.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                //将ViewPager与下面的tab关联起来
                when (position) {
                    0 -> selectTab(MenuTab.HOME)
                    1 -> selectTab(MenuTab.NEARBY)
                    2 -> selectTab(MenuTab.DISCOVER)
                    3 -> selectTab(MenuTab.ORDER)
                    4 -> selectTab(MenuTab.MINE)
                    else -> selectTab(MenuTab.HOME)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }

    private fun selectTab(tab: MenuTab) {
        unCheckedAll()
        when (tab) {
            MenuTab.HOME -> ll_menu_home.isActivated = true
            MenuTab.NEARBY -> ll_menu_nearby.isActivated = true
            MenuTab.ORDER -> ll_menu_order.isActivated = true
            MenuTab.DISCOVER -> ll_menu_discover.isActivated = true
            MenuTab.MINE -> ll_menu_mine.isActivated = true
        }
    }

    private fun unCheckedAll() {
        ll_menu_home.isActivated = false
        ll_menu_nearby.isActivated = false
        ll_menu_order.isActivated = false
        ll_menu_discover.isActivated = false
        ll_menu_mine.isActivated = false
    }

    enum class MenuTab {
        HOME,
        NEARBY,
        DISCOVER,
        ORDER,
        MINE
    }

    override fun onClick(v: View?) {
        when (v) {
            ll_menu_home -> {
                ll_menu_home.isActivated = true
                vp_tab.currentItem = 0
            }
            ll_menu_nearby -> {
                ll_menu_nearby.isActivated = true
                vp_tab.currentItem = 1
            }
            ll_menu_discover -> {
                ll_menu_discover.isActivated = true
                vp_tab.currentItem = 2
            }
            ll_menu_order -> {
                ll_menu_order.isActivated = true
                vp_tab.currentItem = 3
            }
            ll_menu_mine -> {
                ll_menu_mine.isActivated = true
                vp_tab.currentItem = 4
            }
        }
    }
}