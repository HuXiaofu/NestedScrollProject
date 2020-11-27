package com.icinfo.nestedscrolldemo.ui

import android.content.Intent
import android.os.Bundle
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

/**
 *@time：2020/11/27
 *@author:hugaojian
 **/
class SplashActivity : BaseActivity() {
    var count = 4;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take((count + 1).toLong())
                .map { count - it }
                .compose {
                    it.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                }
                .subscribe(Consumer {
                    tv_splash_skip.text = "跳过( $it )"
                }, Consumer {}, Action {
                    startActivity(Intent(this, MainActivity::class.java))//::表示把一个方法当做一个参数，传递到另一个方法中进行使用，通俗的来讲就是引用一个方法
                    finish()
                }
                )
    }
}