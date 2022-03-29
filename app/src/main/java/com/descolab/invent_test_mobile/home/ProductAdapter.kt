package com.descolab.invent_test_mobile.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.descolab.invent_test_mobile.R
import com.descolab.invent_test_mobile.service.db.model.ProductModel

import kotlinx.android.synthetic.main.item_produk.view.*

class ProductAdapter(private val mContext: Context,
                     val mItems: List<ProductModel>,
                     val listener: ListProdukListener) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = mInflater.inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mItems.size
        //return 5
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        if (0 <= position && position < mItems.size) {
            val data = mItems[position]
            // Bind your data here
            holder.bind(data)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: ProductModel) {
            itemView.tvProductName.text = data.productName.toString()
            itemView.tvProductPrice.text = data.price
//            var baseUrl = mContext.getString(R.string.baseUrl)+ data.fotoProduk.toString()
//            Tools.displayImageOriginal(mContext,itemView.ivImageProduk,baseUrl)
            itemView.setOnClickListener {
                listener.toDetailProduk(data)
            }
        }
    }
    interface ListProdukListener {
        fun toDetailProduk(item: ProductModel)
    }
}