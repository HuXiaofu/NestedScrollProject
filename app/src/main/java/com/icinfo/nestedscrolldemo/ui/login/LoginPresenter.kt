package com.icinfo.nestedscrolldemo.ui.login

import com.icinfo.nestedscrolldemo.base.BasePresenter
import com.icinfo.nestedscrolldemo.entity.BannerEntity
import com.icinfo.nestedscrolldemo.http.BaseResponse
import com.icinfo.nestedscrolldemo.http.HttpDefaultObserver
import com.icinfo.nestedscrolldemo.http.RetrofitHelper
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 *@time：2020/12/16
 *@author:hugaojian
 **/
class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view), LoginContract.Presenter {

    override fun login(useName: String, password: String) {
        RetrofitHelper.getApiService()
                .login(useName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<BaseResponse<UserEntity>> {
                    override fun onSuccess(t: BaseResponse<UserEntity>) {
                        if (t.errorCode != 0) {
                            view.onError(t.errorMsg)
                        } else
                            view.loginSuccess()
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        view?.onError("${e.message}")
                    }

                })
    }

}

