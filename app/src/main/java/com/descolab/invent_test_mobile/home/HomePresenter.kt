package com.descolab.invent_test_mobile.home

import android.content.Context
import com.descolab.invent_test_mobile.base.BasePresenter
import com.descolab.invent_test_mobile.service.ApiClient
import com.descolab.invent_test_mobile.service.ApiService
import com.descolab.invent_test_mobile.service.db.model.ProductModel
import com.descolab.invent_test_mobile.service.db.room.ProductDatabase
import com.descolab.invent_test_mobile.service.response.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class HomePresenter (val context: Context,
                     val mView: HomeContract.View)
    : BasePresenter(), HomeContract.UserActionListener {
    private val apiService : ApiService = ApiClient.getClient().create(ApiService::class.java)
    lateinit var db : ProductDatabase

    override fun loadProduct() {
        val call = apiService.getProduct()
        mView.showProgressDialog(true)
        call.enqueue(object : Callback<ResponseData<ArrayList<ProductModel>>> {
            override fun onResponse(call: Call<ResponseData<ArrayList<ProductModel>>>, responseData: Response<ResponseData<ArrayList<ProductModel>>>) {
                mView.showProgressDialog(false)
                if (responseData.isSuccessful) {
                    val resource = responseData.body()
                    if (resource != null) {
                        db = ProductDatabase.getInstance(context) as ProductDatabase
                        resource.value?.let { db.productDao().insertAll(it) }
                        mView.showListProduct(db.productDao().loadAllProduct())
                    }

                } else {
                    showDialog(context, "Error")
                }
            }

            override fun onFailure(call: Call<ResponseData<ArrayList<ProductModel>>>, t: Throwable) {
                mView.showProgressDialog(false)
                call.cancel()
            }
        })
    }

    override fun searchProduct(text: String) {
        db = ProductDatabase.getInstance(context) as ProductDatabase
        mView.showListProduct(db.productDao().loadAllProductSearch(text))
    }

    override fun sortingProduct(text: String) {
        db = ProductDatabase.getInstance(context) as ProductDatabase
        if (text == "Name Product")
        mView.showListProduct(db.productDao().loadAllProductSortedByNameProductAsc())
        else mView.showListProduct(db.productDao().loadAllProductSortedByPriceProductAsc())

    }
}