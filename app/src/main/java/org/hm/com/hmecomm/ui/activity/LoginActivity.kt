package org.hm.com.hmecomm.ui.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import org.hm.com.hmecomm.R
import org.hm.com.logincomponent.RegisterFpwScreen
import org.hm.com.logincomponent.databinding.LoginScreenBinding
import org.hm.com.logincomponent.holder.LoginHolder
import org.hm.com.logincomponent.navigator.LoginInterface

class LoginActivity : AppCompatActivity(),LoginInterface {

    lateinit var inputLayoutUsername : TextInputLayout
    lateinit var inputLayoutPassword : TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<LoginScreenBinding>(this, org.hm.com.logincomponent.R.layout.login_screen)


        inputLayoutUsername = findViewById(R.id.inputLayoutUsername)
        inputLayoutPassword= findViewById(R.id.inputLayoutPassword)
        val holder = LoginHolder(this)

        binding.loginHolder = holder
    }

    override fun onLoginSubmit(username: String, password: String) {

        startActivity(Intent(this,HomeActivity::class.java))

    }

    override fun onSocialLoginSubmit(type: String) {

        when(type)
        {
            "Facebook"-> Toast.makeText(this,"facebook",Toast.LENGTH_LONG).show()
            "Google"-> Toast.makeText(this,"google",Toast.LENGTH_LONG).show()
            "Twitter"-> Toast.makeText(this,"twitter",Toast.LENGTH_LONG).show()

        }
    }



    override fun onTextError(value: Int) {
        when(value)
        {
            0->{
                inputLayoutUsername.error = null
                inputLayoutPassword.isErrorEnabled = false
            }
            1->{
                inputLayoutPassword.error = null
                inputLayoutPassword.isErrorEnabled = false
            }
            org.hm.com.logincomponent.R.id.edtUsername->
            {
                inputLayoutUsername.error = "Username not valid"
                inputLayoutUsername.isErrorEnabled = true
            }
            org.hm.com.logincomponent.R.id.edtPassword->
            {
                inputLayoutPassword.error = "Password not valid"
                inputLayoutPassword.isErrorEnabled = true
            }
        }
    }

    override fun onSelectForgetPwd() {

        val fpwIntent = Intent(this, RegisterFpwScreen::class.java)
        fpwIntent.putExtra("FPW","")
        startActivityForResult(fpwIntent,100)

    }

    override fun onSelectRegister() {

        Toast.makeText(this,"Select Register Implementation",Toast.LENGTH_LONG).show()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       /* val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(parentLayout.windowToken, 0)*/
        when(requestCode)
        {
            100->
            {
                data?.let {
                    Toast.makeText(this,"ForgetPassword successfully sent"+data?.getStringExtra("result"),Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
