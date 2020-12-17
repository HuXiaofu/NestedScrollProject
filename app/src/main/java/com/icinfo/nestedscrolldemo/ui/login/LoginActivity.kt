package com.icinfo.nestedscrolldemo.ui.login

import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.icinfo.nestedscrolldemo.MainActivity
import com.icinfo.nestedscrolldemo.R
import com.icinfo.nestedscrolldemo.base.AppBaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 *@time：2020/12/16
 *@author:hugaojian
 **/
class LoginActivity : AppBaseActivity<LoginContract.Presenter>(),LoginContract.View, View.OnClickListener {

    private var isPasswordShow = false

    override fun init(savedInstanceState: Bundle?) {
        setHideStatusBar(true)

        icVlear.setOnClickListener(this)
        icSee.setOnClickListener(this)
        tvNotLogin.setOnClickListener(this)
        mbLogin.setOnClickListener(this)
    }

    override fun createPresenter(): LoginContract.Presenter? {
        return LoginPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.icVlear -> {
                etUseName.setText("")
            }
            R.id.icSee -> {
                etPassword.transformationMethod = if (isPasswordShow) {
                    isPasswordShow = false
                    icSee.setImageResource(R.mipmap.password_show)
                    PasswordTransformationMethod.getInstance()
                } else {
                    isPasswordShow = true
                    icSee.setImageResource(R.mipmap.password_hide)
                    HideReturnsTransformationMethod.getInstance()
                }
                etPassword.setSelection(etPassword.text.length)
            }
            R.id.mbLogin -> {
                val userName = etUseName.text.toString()
                val password = etPassword.text.toString()
                when{
                    userName.isEmpty()->Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show()
                    password.isEmpty()->Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show()
                    else ->{
                        presenter?.login(userName,password)
                    }
                }
            }
            R.id.tvNotLogin -> {
                intent(MainActivity::class.java, false)
                finish()
            }
        }
    }

    override fun loginSuccess() {
        intent(MainActivity::class.java, false)
        finish()
    }

    override fun getContext(): Context? {
        return this
    }

    override fun onError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}