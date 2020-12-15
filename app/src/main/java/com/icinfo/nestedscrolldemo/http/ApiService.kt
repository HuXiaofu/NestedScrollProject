package com.icinfo.nestedscrolldemo.http

import com.icinfo.nestedscrolldemo.entity.BannerEntity
import com.icinfo.nestedscrolldemo.ui.discover.ArticleEntity
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") pageNo:Int):Observable<BaseResponse<ArticleEntity>>
    /**
     * banner
     */
    @GET("/banner/json")
    fun getBanner():Observable<BaseResponse<MutableList<BannerEntity>>>

}
