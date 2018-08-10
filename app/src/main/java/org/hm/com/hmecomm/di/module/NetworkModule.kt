package org.hm.com.hmecomm.di.module

import android.graphics.Bitmap
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import org.hm.com.hmecomm.api.ApiService
import org.hm.com.hmecomm.app.Application
import org.hm.com.hmecomm.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(val application : Application,val baseUrl : String) {

    @Provides
    @Singleton
    fun providesApiService(retrofit : Retrofit) :ApiService
    {
        return  retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit
    {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

}