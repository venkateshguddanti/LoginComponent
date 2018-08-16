package org.hm.com.logincomponent

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_fpw_screen.*
import org.hm.com.logincomponent.databinding.ActivityRegisterFpwScreenBinding
import org.hm.com.logincomponent.holder.LoginHolder
import org.hm.com.logincomponent.navigator.LoginInterface


class RegisterFpwScreen : AppCompatActivity(),LoginInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityRegisterFpwScreenBinding>(this,R.layout.activity_register_fpw_screen)

        val holder = LoginHolder(this)
        binding.loginHolder = holder
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.txt_FPW)


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onLoginSubmit(username: String, password: String) {

    }

    override fun onSocialLoginSubmit(type: String) {

        val returnIntent = Intent()
        returnIntent.putExtra("result",type)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    override fun onTextError(value: Int) {

        if(value == 0)
        {
            inputLayoutFPW.error = null
            inputLayoutFPW.isErrorEnabled = false
        }else {
            inputLayoutFPW.error = getString(R.string.txt_field_error)
        }
    }


    override fun onSelectForgetPwd() {

    }

    override fun onSelectRegister() {

    }


}
