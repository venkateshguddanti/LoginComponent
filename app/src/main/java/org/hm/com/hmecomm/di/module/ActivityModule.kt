package org.hm.com.hmecomm.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activty : Activity) {


    @Provides
    fun getActivity() : Activity
    {
        return this.activty;
    }

    @Provides
    fun getContext() : Context
    {
        return this.activty;
    }


}