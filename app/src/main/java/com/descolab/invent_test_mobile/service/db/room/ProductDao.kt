package com.descolab.invent_test_mobile.service.db.room

import androidx.room.*
import com.descolab.invent_test_mobile.service.db.model.ProductModel

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table")
    fun loadAllProduct(): List<ProductModel>

    @Query("SELECT * FROM product_table ORDER BY product_name ASC")
    fun loadAllProductSortedByNameProductAsc(): List<ProductModel>

    @Query("SELECT * FROM product_table ORDER BY price ASC")
    fun loadAllProductSortedByPriceProductAsc(): List<ProductModel>

    @Query("SELECT * FROM product_table WHERE product_name  LIKE '%' || :text || '%' OR price LIKE '%' || :text || '%'")
    fun loadAllProductSearch(text: String): List<ProductModel>

    @Insert
    fun addTask(myTask: ProductModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<ProductModel?>)

    @Delete
    fun deleteTask(myTask: ProductModel)

}