package org.hm.com.hmecomm.di.component

import android.content.SharedPreferences
import dagger.Component
import org.hm.com.hmecomm.api.ApiService
import org.hm.com.hmecomm.app.Application
import org.hm.com.hmecomm.di.module.ActivityModule
import org.hm.com.hmecomm.di.module.ApplicationModule
import org.hm.com.hmecomm.di.module.NetworkModule
import org.hm.com.hmecomm.di.module.StorageModule
import org.hm.com.hmecomm.ui.activity.BaseActivity
import org.hm.com.hmecomm.ui.activity.HomeActivity
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class,NetworkModule::class,StorageModule::class))
interface ApplicationComponent {


    fun inject(app : Application)
    fun application() : Application
    fun retrofit():Retrofit
    fun apiService():ApiService
    fun sharedPreferences(): SharedPreferences


}