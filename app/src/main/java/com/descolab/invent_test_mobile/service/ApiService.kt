package com.descolab.invent_test_mobile.service

import com.descolab.invent_test_mobile.BuildConfig
import com.descolab.invent_test_mobile.service.response.ArticlesItem
import com.descolab.invent_test_mobile.service.responsee.ResponseArticle
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface ApiService {

    @GET("top-headlines?country=id&apiKey=${BuildConfig.API_KEY}")
    fun getTopHeadline(): Call<ResponseArticle<ArrayList<ArticlesItem>>>



}
