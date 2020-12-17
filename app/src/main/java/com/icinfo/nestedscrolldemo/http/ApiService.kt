package com.icinfo.nestedscrolldemo.http

import com.icinfo.nestedscrolldemo.entity.BannerEntity
import com.icinfo.nestedscrolldemo.ui.login.UserEntity
import com.icinfo.nestedscrolldemo.ui.discover.ArticleEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.http.*

interface ApiService {

    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") pageNo: Int): Observable<BaseResponse<ArticleEntity>>

    /**
     * banner
     */
    @GET("/banner/json")
    fun getBanner(): Observable<BaseResponse<MutableList<BannerEntity>>>

    /**
     * login
     */
    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") userName: String, @Field("password") password: String): Single<BaseResponse<UserEntity>>
}
