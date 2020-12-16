package com.icinfo.nestedscrolldemo.ui

import android.content.Intent
import android.os.Bundle
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.AppBaseActivity
import com.icinfo.nestedscrolldemo.base.BaseActivity
import com.icinfo.nestedscrolldemo.base.IBasePresenter
import com.icinfo.nestedscrolldemo.ui.login.LoginActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
class SplashActivity : AppBaseActivity<IBasePresenter<*>>() {
    private var count = 4

    override fun init(savedInstanceState: Bundle?) {
        val disposable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take((count + 1).toLong())
                .map { count - it }
                .compose {
                    it.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                }
                .subscribe(Consumer {
                    tv_splash_skip.text = "跳过( $it )"
                }, Consumer {}, Action {
                    intent(LoginActivity::class.java,true)
                    finish()
                })

        tv_splash_skip.setOnClickListener {
            disposable.dispose()
            intent(MainActivity::class.java,false)
            finish()
        }
    }

    override fun createPresenter(): IBasePresenter<*>? {
        return null
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }
}