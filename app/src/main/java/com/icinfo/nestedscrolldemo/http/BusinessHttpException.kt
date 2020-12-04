package com.icinfo.nestedscrolldemo.http

import java.io.IOException

class BusinessHttpException(val businessMessage:String,val businessCode:Int) :IOException()

