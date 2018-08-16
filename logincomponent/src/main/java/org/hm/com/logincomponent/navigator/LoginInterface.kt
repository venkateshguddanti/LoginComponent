package org.hm.com.logincomponent.navigator

import android.view.View
import java.net.PasswordAuthentication

interface LoginInterface {


    fun onLoginSubmit(username : String,password : String)
    fun onSocialLoginSubmit(type : String)
    fun onTextError(value: Int)
    fun onSelectForgetPwd()
    fun onSelectRegister()

}