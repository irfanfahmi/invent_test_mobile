package com.descolab.invent_test_mobile.service.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.descolab.invent_test_mobile.service.db.model.ProductModel

@Database(entities = arrayOf(ProductModel::class), version = 1)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        val DB_NAME = "product_db"
        var instance: ProductDatabase? = null

        fun getInstance(context: Context): RoomDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, ProductDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as ProductDatabase
        }
    }

}