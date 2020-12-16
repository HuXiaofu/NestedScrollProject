package com.icinfo.nestedscrolldemo.ui.login

import android.os.Bundle
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.AppBaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 *@time：2020/12/16
 *@author:hugaojian
 **/
class LoginActivity : AppBaseActivity<LoginContract.Presenter>() {

    override fun init(savedInstanceState: Bundle?) {
        setHideStatusBar(true)

        tvNotLogin.setOnClickListener {
            intent(MainActivity::class.java, false)
            finish()
        }
    }

    override fun createPresenter(): LoginContract.Presenter? {
        return null
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
}