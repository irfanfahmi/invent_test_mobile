package com.descolab.invent_test_mobile.service

import com.descolab.invent_test_mobile.service.db.model.ProductModel
import com.descolab.invent_test_mobile.service.response.Product
import com.descolab.invent_test_mobile.service.response.ResponseData
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface ApiService {

    @GET("get_m_product")
    fun getProduct(): Call<ResponseData<ArrayList<ProductModel>>>

    @GET("get_product_price")
    fun getProductPrice(): Call<ResponseData<ArrayList<ProductModel>>>



}
