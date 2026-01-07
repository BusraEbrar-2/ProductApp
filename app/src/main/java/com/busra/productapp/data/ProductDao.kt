package com.busra.productapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.busra.productapp.model.Product

@Dao
interface ProductDao
{
    @Query ("SELECT*From product")
    suspend fun getAllProducts() : List<Product>

    @Insert
    suspend fun insertProduct (product: Product)

    @Delete
    suspend fun deleteProduct (product: Product)


}





// suspend bu fonksıyon askıya alınabılır
    // uzun surebılcek bır ıslem yapabılır

