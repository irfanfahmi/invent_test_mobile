package com.descolab.invent_test_mobile.home

import android.app.ProgressDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.descolab.invent_test_mobile.R
import com.descolab.invent_test_mobile.service.db.model.ProductModel
import com.descolab.invent_test_mobile.service.db.room.ProductDatabase
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View, ProductAdapter.ListProdukListener {
    private var progressDialog : ProgressDialog? = null
    private var mActionListener: HomePresenter? = null
    private var mAdapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(context)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)
        mActionListener = context?.let { HomePresenter(it, this) }
        mActionListener?.loadProduct()

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                if (text != null) {
                    mActionListener?.searchProduct(text.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        etSort.setOnClickListener {
            displaySort(it)
        }

    }

    fun displaySort(v: View){
        val array = arrayOf("Name Product","Price Product")
        val builder = context?.let { androidx.appcompat.app.AlertDialog.Builder(it) }
        builder?.setTitle("Sort By")
        builder?.setSingleChoiceItems( array, -1 ) {
                dialogInterface, i ->
            (v as EditText).setText(array[i])
            mActionListener?.sortingProduct(array[i])
            dialogInterface.dismiss()
        }
        builder?.show()
    }


    override fun showProgressDialog(show: Boolean) {
        if (show) progressDialog?.show()
        else progressDialog?.dismiss()
    }

    override fun showListProduct(data: List<ProductModel>) {
        Log.d("cek isi db",data.toString())
        mAdapter = context?.let {
            ProductAdapter(it, data, this)
        }
        rvProduct?.setHasFixedSize(true)
        rvProduct?.adapter = mAdapter
    }

    override fun toDetailProduk(item: ProductModel) {
        Log.d("klik",item.toString())
    }


}