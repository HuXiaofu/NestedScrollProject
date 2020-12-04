package com.icinfo.nestedscrolldemo.http

import com.google.gson.JsonParseException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.json.JSONException
import java.lang.reflect.ParameterizedType
import java.net.Socket
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class HttpDefaultObserver<T> : Observer<BaseResponse<T>> {

    override fun onComplete() {
        TODO("Not yet implemented")
    }
    override fun onSubscribe(d: Disposable) {
        disposable(d)
    }

    override fun onNext(t: BaseResponse<T>) {
        if (t.errorCode == 0) {
            if (t.data == null) {
                val tClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
                t.data = tClass.newInstance()
            }
            t.data?.let { onSuccess(it) }
        } else {
            filterCode(t.errorMsg, t.errorCode)
        }
    }

    override fun onError(e: Throwable) {
        var errorMsg = if (e is UnknownHostException) {
            "网络异常"
        } else if (e is JSONException || e is JsonParseException) {
            "数据异常"
        } else if (e is SocketTimeoutException) {
            "连接超时"
        } else if (e is BusinessHttpException) {
            e.businessMessage
        } else {
            "未知异常"
        }

        onError(errorMsg)
    }

    private fun filterCode(errorMsg: String, errorCode: Int) {
        when (errorCode) {
            -1001 -> {
                onError(BusinessHttpException(errorMsg, errorCode))
            }
            else -> onError(BusinessHttpException(errorMsg, errorCode))
        }
    }

    abstract fun disposable(d: Disposable)
    abstract fun onSuccess(t: T)
    abstract fun onError(errorMsg: String)
}
