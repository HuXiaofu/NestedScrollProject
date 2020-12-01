package com.icinfo.nestedscrolldemo.base

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
open class BaseFragment : Fragment() {
    private val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val shouldHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN)
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            if (shouldHidden) {
                transaction.hide(this)
            } else {
                transaction.show(this)
            }
        }
    }

    override fun onSaveInstanceState(@NonNull outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }
}