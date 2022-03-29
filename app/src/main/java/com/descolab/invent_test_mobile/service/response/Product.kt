package com.descolab.invent_test_mobile.service.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(

    @field:SerializedName("dnr_code")
    val dnrCode: String? = null,

    @field:SerializedName("sap_code")
    val sapCode: String? = null,

    @field:SerializedName("uom")
    val uom: String? = null,

    @field:SerializedName("is_ppn_include")
    val isPpnInclude: String? = null,

    @field:SerializedName("product_type")
    val productType: String? = null,

    @field:SerializedName("product_weight")
    val productWeight: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("product_weight_uom")
    val productWeightUom: String? = null,

    @field:SerializedName("product_id")
    val productId: String? = null,

    @field:SerializedName("product_group")
    val productGroup: String? = null,

    @field:SerializedName("product_name")
    val productName: String? = null,

    @field:SerializedName("branch_id")
    val branch_id: String? = null

) : Parcelable