package org.hm.com.logincomponent.holder

import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.util.Patterns
import android.text.TextUtils
import android.text.Editable
import org.hm.com.logincomponent.navigator.LoginInterface
import org.hm.com.logincomponent.R


class LoginHolder(val listener : LoginInterface)
{


    var userName : CharSequence =""
    var password : CharSequence =""
    var forgetPwdOTP : CharSequence =""

    fun onTextChanged(editText : EditText) : TextWatcher
    {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                when(editText.id)
                {
                    R.id.edtUsername ->{
                        userName = s
                        if(isValidEmail(userName))
                        {
                            listener.onTextError(0)
                        }
                    }
                    R.id.edtPassword ->{
                        password = s
                        if(password.length != 0)
                        {
                            listener.onTextError(1)
                        }
                    }
                    R.id.edtMobileOrEmail->{
                        forgetPwdOTP =s
                        if(forgetPwdOTP.length != 0)
                        {
                            listener.onTextError(0)
                        }
                    }

                }


            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.

            }
        }


    }

    fun onViewClicked() : View.OnClickListener
    {
       return View.OnClickListener { v ->
           when(v.id)
           {
               R.id.buttonLogin ->onLogin()
               R.id.facebookLogin ->onSocialLogin("Facebook")
               R.id.googleLogin ->onSocialLogin("Google")
               R.id.twitterLogin ->onSocialLogin("Twitter")
               R.id.forgetPwd ->onFPWD()
               R.id.notRegister ->onNotRegister()
               R.id.buttonOTP->onFPWOTP()
           }

       }
    }

    fun onFPWOTP()
    {
        if(forgetPwdOTP.length == 0) {
            listener.onTextError(R.id.edtMobileOrEmail)
            return
        }
        listener.onSocialLoginSubmit(forgetPwdOTP.toString())
    }

    fun onLogin()
    {
        if( userName.length == 0 || !isValidEmail(userName))
        {
            listener.onTextError(R.id.edtUsername)
            return
        }
        if(password.length == 0)
        {
            listener.onTextError(R.id.edtPassword)
            return
        }

        listener.onLoginSubmit(userName.toString(),password.toString())
    }
    fun onSocialLogin(type : String)
    {
        when(type)
        {
           "Facebook"->listener.onSocialLoginSubmit(type)
            "Google"->listener.onSocialLoginSubmit(type)
            "Twitter"->listener.onSocialLoginSubmit(type)
        }
    }
    fun onFPWD()
    {
        listener.onSelectForgetPwd()
    }
    fun onNotRegister()
    {
        listener.onSelectRegister()
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}