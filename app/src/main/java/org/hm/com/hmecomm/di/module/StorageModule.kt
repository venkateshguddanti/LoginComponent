package org.hm.com.hmecomm.di.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import org.hm.com.hmecomm.app.Application
import javax.inject.Singleton

@Module
class StorageModule(val application : Application) {

    @Provides
    @Singleton
    fun provideSharedPreference(application: Application) : SharedPreferences
    {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}