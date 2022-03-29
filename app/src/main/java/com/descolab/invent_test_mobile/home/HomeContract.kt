package com.descolab.invent_test_mobile.home


class HomeContract {
    interface View{
        fun showProgressDialog(show: Boolean)
    }

    interface UserActionListener{
       fun loadProduct()
    }
}