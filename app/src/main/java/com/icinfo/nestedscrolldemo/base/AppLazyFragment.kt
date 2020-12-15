package com.icinfo.nestedscrolldemo.base

import android.content.Intent
import com.icinfo.nestedscrolldemo.ui.SplashActivity
import com.icinfo.nestedscrolldemo.utils.AppManager

/**
 *@time：2020/12/4
 *@author:hugaojian
 **/
abstract class AppLazyFragment<P:IBasePresenter<*>>: LazyFragment<P>() {

    protected fun intent(clazz:Class<*>,isLogin:Boolean){
        if (isLogin&&!AppManager.isLogin()){
            startActivity(Intent(context,SplashActivity::class.java))
        }
    }
}