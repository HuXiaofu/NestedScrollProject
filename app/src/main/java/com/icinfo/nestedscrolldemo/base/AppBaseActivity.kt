package com.icinfo.nestedscrolldemo.base

import android.content.Intent
import android.os.Bundle
import com.icinfo.nestedscrolldemo.ui.login.LoginActivity
import com.icinfo.nestedscrolldemo.utils.AppManager

/**
 *@time：2020/12/16
 *@author:hugaojian
 **/
abstract class AppBaseActivity<P : IBasePresenter<*>> : BaseActivity<P>() {

    /**
     *activity跳转
     **/
    protected fun intent(clazz: Class<*>, isLogin: Boolean) {
        if (isLogin && AppManager.isLogin()) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, clazz))
        }
    }

    /**
     * 携参跳转
     */
    protected fun intent(bundle: Bundle, clazz: Class<*>, isLogin: Boolean) {
        if (isLogin && AppManager.isLogin()) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, clazz).apply { putExtras(bundle) })
        }
    }
}