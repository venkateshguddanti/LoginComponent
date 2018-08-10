package org.hm.com.logincomponent

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import org.hm.com.logincomponent.databinding.LoginScreenBinding

class LoginScreen : AppCompatActivity(),LoginInterface {


    private lateinit var binding : LoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.login_screen)
        binding = DataBindingUtil.setContentView<LoginScreenBinding>(this,R.layout.login_screen)


        val holder = LoginHolder(this)

        binding.loginHolder = holder



    }

    override fun onLoginSubmit(username: String, password: String) {
        result()
    }

    override fun onSocialLoginSubmit(type: String) {

        when(type)
        {
            "Faccebook"-> Toast.makeText(this,"facebook",Toast.LENGTH_LONG).show()
            "Google"-> Toast.makeText(this,"google",Toast.LENGTH_LONG).show()
            "Twitter"-> Toast.makeText(this,"twitter",Toast.LENGTH_LONG).show()

        }
    }


    fun result()
    {
        Toast.makeText(this,"login",Toast.LENGTH_LONG).show()
    }

    override fun onTextError(value: Int) {
        when(value)
        {
            R.id.edtUsername->Toast.makeText(this,"Username not valid",Toast.LENGTH_LONG).show()
            R.id.edtPassword->Toast.makeText(this,"Password not valid",Toast.LENGTH_LONG).show()
        }
    }

    override fun onSelectForgetPwd() {

    }

    override fun onSelectRegister() {

    }
}
