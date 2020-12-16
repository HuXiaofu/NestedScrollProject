package com.icinfo.nestedscrolldemo.ui.login

import com.icinfo.nestedscrolldemo.base.IBasePresenter
import com.icinfo.nestedscrolldemo.base.IBaseView

/**
 *@time：2020/12/16
 *@author:hugaojian
 **/
interface LoginContract {
    interface View : IBaseView {
        fun loginSuccess()
    }

    interface Presenter : IBasePresenter<View> {
        fun login(useName: String, password: String)
    }
}