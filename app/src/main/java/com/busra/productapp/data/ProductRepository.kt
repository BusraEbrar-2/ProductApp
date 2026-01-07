package com.busra.productapp.data

import androidx.room.Delete
import com.busra.productapp.model.Product

class ProductRepository (private val productDao : ProductDao) {


    suspend fun getAllProducts (): List<Product> {
        return productDao.getAllProducts()
    }

    suspend fun insertProduct (product: Product) {
        productDao.insertProduct(product)
    }


    suspend fun deleteProduct (product: Product)
    {
        productDao.deleteProduct(product)
    }

}
