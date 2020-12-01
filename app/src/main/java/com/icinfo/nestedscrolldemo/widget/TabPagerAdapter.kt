package com.icinfo.nestedscrolldemo.widget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.icinfo.nestedscrolldemo.base.BaseFragment

class TabPagerAdapter(fm:FragmentManager, private val fragmentList:List<BaseFragment>) :FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}
