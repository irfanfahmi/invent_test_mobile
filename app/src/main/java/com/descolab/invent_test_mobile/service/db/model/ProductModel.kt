package com.descolab.invent_test_mobile.service.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product_table")
data class ProductModel(
    @PrimaryKey
    @field:SerializedName("product_id")
    @ColumnInfo(name = "product_id")
    var productId: String,

    @field:SerializedName("dnr_code")
    @ColumnInfo(name = "dnr_code")
    var dnrCode: String?,

    @field:SerializedName("sap_code")
    @ColumnInfo(name = "sap_code")
    var sapCode: String?,

    @field:SerializedName("uom")
    @ColumnInfo(name = "uom")
    var uom: String?,

    @field:SerializedName("is_ppn_include")
    @ColumnInfo(name = "is_ppn_include")
    var isPpnInclude: String?,

    @field:SerializedName("product_type")
    @ColumnInfo(name = "product_type")
    var productType: String?,

    @field:SerializedName("product_weight")
    @ColumnInfo(name = "product_weight")
    var productWeight: String?,

    @field:SerializedName("price")
    @ColumnInfo(name = "price")
    var price: Double?,

    @field:SerializedName("product_weight_uom")
    @ColumnInfo(name = "product_weight_uom")
    var productWeightUom: String?,

    @field:SerializedName("product_group")
    @ColumnInfo(name = "product_group")
    var productGroup: String?,

    @field:SerializedName("product_name")
    @ColumnInfo(name = "product_name")
    var productName: String?,

    @field:SerializedName("branch_id")
    @ColumnInfo(name = "branch_id")
    var branchId: String?


)