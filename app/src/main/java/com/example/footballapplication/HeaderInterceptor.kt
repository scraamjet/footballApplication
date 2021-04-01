package com.example.footballapplication

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain):Response{
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Auth-Token","1e313355a6ce486b87a3ac92018cb12b")
            .build()
        return chain.proceed(request)
    }
}