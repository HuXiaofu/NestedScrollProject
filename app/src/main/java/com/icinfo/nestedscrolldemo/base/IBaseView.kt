package com.icinfo.nestedscrolldemo.base

import android.content.Context

interface IBaseView {

    fun getContext(): Context?
    fun onError(error: String)
}
