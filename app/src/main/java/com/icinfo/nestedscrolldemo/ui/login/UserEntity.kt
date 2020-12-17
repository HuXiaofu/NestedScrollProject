package com.icinfo.nestedscrolldemo.ui.login

data class UserEntity(var admin: Boolean = false,
                      var email: String? = null,
                      var icon: String? = null,
                      var id: Int = 0,
                      var nickname: String? = null,
                      var password: String? = null,
                      var publicName: String? = null,
                      var token: String? = null,
                      var type: Int = 0,
                      var username: String? = null,
                      var chapterTops: List<*>? = null,
                      var collectIds: List<Int>? = null)
