package org.hm.com.hmecomm.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.hm.com.hmecomm.app.Application

@Module
class ApplicationModule (val application : Application) {

    @Provides
    fun providesApplicationContext() : Context
    {
        return this.application;
    }
    @Provides
    fun providesApplication() : Application
    {
        return this.application;
    }
}