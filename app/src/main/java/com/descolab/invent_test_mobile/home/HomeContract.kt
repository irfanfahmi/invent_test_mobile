package com.descolab.invent_test_mobile.home

import com.descolab.invent_test_mobile.service.db.model.ProductModel


class HomeContract {
    interface View{
        fun showProgressDialog(show: Boolean)
        fun showListProduct(data: List<ProductModel>)
    }

    interface UserActionListener{
       fun loadProduct()
       fun searchProduct(text: String)
       fun sortingProduct(text: String)
    }
}