package com.descolab.invent_test_mobile.home

import android.content.Context
import com.descolab.invent_test_mobile.base.BasePresenter
import com.descolab.invent_test_mobile.service.ApiClient
import com.descolab.invent_test_mobile.service.ApiService
import com.descolab.invent_test_mobile.service.response.Product
import com.descolab.invent_test_mobile.service.response.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class HomePresenter (val context: Context,
                     val mView: HomeContract.View)
    : BasePresenter(), HomeContract.UserActionListener {
    private val apiService : ApiService = ApiClient.getClient().create(ApiService::class.java)

    override fun loadProduct() {
        val call = apiService.getProduct()
        mView.showProgressDialog(true)
        call.enqueue(object : Callback<ResponseData<ArrayList<Product>>> {
            override fun onResponse(call: Call<ResponseData<ArrayList<Product>>>, responseArticle: Response<ResponseData<ArrayList<Product>>>) {
                mView.showProgressDialog(false)
                if (responseArticle.isSuccessful) {
                    val resource = responseArticle.body()
                    if (resource != null) {

                    }

                } else {
                    showDialog(context, "Error")
                }
            }

            override fun onFailure(call: Call<ResponseData<ArrayList<Product>>>, t: Throwable) {
                mView.showProgressDialog(false)
                call.cancel()
            }
        })
    }
}