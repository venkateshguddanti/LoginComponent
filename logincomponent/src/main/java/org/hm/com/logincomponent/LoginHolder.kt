package org.hm.com.logincomponent

import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.util.Patterns
import android.text.TextUtils
import android.text.Editable
import android.databinding.adapters.TextViewBindingAdapter.setPassword





class LoginHolder(val listener : LoginInterface)
{

   lateinit var userName : CharSequence
   lateinit var password : CharSequence

    fun onTextChanged(editText: EditText) : TextWatcher
    {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                when(editText.id)
                {
                    R.id.edtUsername->userName = s
                    R.id.edtPassword->password = s
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
               R.id.buttonLogin->onLogin(v)
               R.id.facebookLogin->onSocialLogin("Facebook",v)
               R.id.googleLogin->onSocialLogin("Google",v)
               R.id.twitterLogin->onSocialLogin("Twitter",v)
               R.id.forgetPwd->onFPWD(v)
               R.id.notRegister->onNotRegister(v)
           }

       }
    }


    fun onLogin(v : View)
    {
        if(userName == null || userName.length == 0 || isValidEmail(userName))
        {
            listener.onTextError(R.id.edtUsername)
            return
        }
        if(password == null || password.length == 0)
        {
            listener.onTextError(R.id.edtPassword)
            return
        }

        listener.onLoginSubmit(userName.toString(),password.toString())
    }
    fun onSocialLogin(type : String,v:View)
    {
        when(type)
        {
           "Facebook"->listener.onSocialLoginSubmit(type)
            "Google"->listener.onSocialLoginSubmit(type)
            "Twitter"->listener.onSocialLoginSubmit(type)
        }
    }
    fun onFPWD(v:View)
    {
        listener.onSelectForgetPwd()
    }
    fun onNotRegister(v:View)
    {
        listener.onSelectRegister()
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}