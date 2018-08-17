# LoginComponent

Before going to this you should bit familier with [databinding](https://developer.android.com/topic/libraries/data-binding/) concept in android 

This component consist of implementation of Sample login screen and forget password screen with all handlings using kotlin and data binding concept

Make following changes to use this component in your kotlin project

in project level build.gradle add following
```
allprojects {
    repositories {
       --------        
       --------
        maven { url 'https://jitpack.io' } 
    }
  }
  ```
  in app leavel build.gradle file add following
```
android
{
 -----
 -----
 dataBinding
       {
           enabled = true          //This component build up on concept of databinding 
       }
  compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8              //For supporting Invoke-Customs
        targetCompatibility JavaVersion.VERSION_1_8
    }
 }
```     
under depedencies add the follwing gradle pllugin

```
dependencies {
    -----
    implementation 'com.github.venkateshguddanti:LoginComponent:0.0.1'
}
```
For avoiding multiDex error please add the following in your gradle.properties

```
android.enableD8.desugaring = true
```
**Project Setup**

On successfull build of project you are ready to use the component

Create an activty for login screen as LoginActivity(Give any name apart from **LoginScreen** to avoid conflict of name used in component)
and add the following code in onCreate of your activity

We no need to desing any .xml file since it is already available in component


```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<LoginScreenBinding>(this, R.layout.login_screen)
        
         lateinit var inputLayoutUsername : TextInputLayout   // Since kotlin extension not working from module we should define UI component to update
         lateinit var inputLayoutPassword : TextInputLayout
    
        val holer = LoginHolder(this)
        binding.loginHolder = holer
    }
```
On first build you may get error saying LoginScreenBinding not resolved a type for avoiding Run your app once . After that try to import LoginScreenBinding (This class is Data binding generated class which is smilar to its .xml file (login_screen)

Implement your activity with LoginInterface to get all the actions from Login component 

```
   override fun onLoginSubmit(username: String, password: String) {

       //Fired on click on login button after Username and Password validations
       //On login logic goes here
    }

    override fun onSelectRegister() {
       //On Register logic goes here
    }

    override fun onTextError(value: Int) {
       //Fires Each and every time text entering in EditText 
       //Retruns edittext id to update corresponding user friendly error message
       //Use 0 for username and 1 for password to set no error
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

          //Launch forgetpassword screen from component which will return data in onActivityResult()
          val fpwIntent = Intent(this, RegisterFpwScreen::class.java)
          startActivityForResult(fpwIntent,100)
    }

    override fun onSocialLoginSubmit(type: String) {

         //Fires on cilck on any social login from component where type is "Facebook","Google","Twitter"
    }
```
Handle forget password submit 

```
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
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
  ```
  
  For customizing UI download the above project and add logincomponent to your project as a module and continue coding.
  
  
  
