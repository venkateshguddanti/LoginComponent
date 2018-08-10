package org.hm.com.hmecomm.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.hm.com.hmecomm.R
import org.hm.com.hmecomm.app.Application
import org.hm.com.hmecomm.di.component.ActivityComponent
import org.hm.com.hmecomm.di.component.ApplicationComponent
import org.hm.com.hmecomm.di.component.DaggerActivityComponent

open  class BaseActivity : AppCompatActivity() {


    companion object {
        lateinit var activityComponent:ActivityComponent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        activityComponent = DaggerActivityComponent
                .builder()
                .applicationComponent((application as Application).getApplicaitonComponent())
                .build()
        this.getActivityComponent().inject(this)

    }

    fun getActivityComponent() : ActivityComponent
    {
        return activityComponent
    }
}
