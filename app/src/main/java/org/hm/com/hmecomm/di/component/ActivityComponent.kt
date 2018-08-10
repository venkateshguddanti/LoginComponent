package org.hm.com.hmecomm.di.component

import dagger.Component
import org.hm.com.hmecomm.api.ApiService
import org.hm.com.hmecomm.di.module.ActivityModule
import org.hm.com.hmecomm.di.scope.ActivityScope
import org.hm.com.hmecomm.ui.activity.BaseActivity
import org.hm.com.hmecomm.ui.activity.HomeActivity
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent
{

    fun inject(activity:BaseActivity)
    fun inject(activity:HomeActivity)

}