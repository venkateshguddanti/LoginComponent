package org.hm.com.hmecomm.api

import io.reactivex.Observable
import org.hm.com.hmecomm.models.Post
import retrofit2.http.GET

interface ApiService
{
    @GET("/posts")
    fun getPosts():Observable<List<Post>>
}