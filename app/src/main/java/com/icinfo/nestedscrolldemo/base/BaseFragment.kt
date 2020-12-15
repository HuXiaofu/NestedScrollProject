package com.icinfo.nestedscrolldemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
abstract class BaseFragment<P:IBasePresenter<*>> : Fragment() {

    private val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"
    protected var presenter:P?=null
    private var contentView:View?=null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=createPresenter()
        presenter?.let { lifecycle.addObserver(it) }
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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView=inflater.inflate(getLayoutId(),null)
        return contentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init(savedInstanceState)
    }


    override fun onSaveInstanceState(@NonNull outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }

    abstract fun init(savedInstanceState: Bundle?)
    abstract fun createPresenter(): P?
    abstract fun getLayoutId(): Int
}