package com.example.navigationdemo.api

import com.example.navigationdemo.api_secret.RestApi
import com.example.navigationdemo.api_secret.ServiceBuilder
import com.example.navigationdemo.model.BundlePostBody
import com.example.navigationdemo.model.NewsJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun askNews(bundlePostBody: BundlePostBody, onResult: (NewsJson?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.askNews(bundlePostBody).enqueue(
            object : Callback<NewsJson> {
                override fun onFailure(call: Call<NewsJson>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<NewsJson>, response: Response<NewsJson>) {
                    val newsResponse = response.body()
                    onResult(newsResponse)
                }
            }
        )
    }
}