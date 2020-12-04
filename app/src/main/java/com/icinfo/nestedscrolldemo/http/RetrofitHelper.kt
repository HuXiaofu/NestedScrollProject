package com.icinfo.nestedscrolldemo.http

/**
 *@time：2020/12/2
 *@author:hugaojian
 **/
object RetrofitHelper {

    fun getApiService(): ApiService {
        return RetrofitFactory.factory().create(ApiService::class.java)
    }
}