package org.hm.com.hmecomm.app

import com.facebook.drawee.backends.pipeline.Fresco
import org.hm.com.hmecomm.di.component.ApplicationComponent
import org.hm.com.hmecomm.di.component.DaggerApplicationComponent
import org.hm.com.hmecomm.di.module.ApplicationModule
import org.hm.com.hmecomm.di.module.NetworkModule
import org.hm.com.hmecomm.di.module.StorageModule
import org.hm.com.hmecomm.util.BASE_URL

class Application : android.app.Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(this, BASE_URL))
                .storageModule(StorageModule(this))
                .build()



    }
    fun getApplicaitonComponent() : ApplicationComponent
    {
        return applicationComponent;
    }
}