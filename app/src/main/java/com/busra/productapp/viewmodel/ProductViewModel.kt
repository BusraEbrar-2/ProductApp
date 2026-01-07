package com.busra.productapp.viewmodel
import com.busra.productapp.R

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.util.appendPlaceholders
import com.busra.productapp.data.ProductDatabase
import com.busra.productapp.data.ProductRepository
import com.busra.productapp.model.Product
import kotlinx.coroutines.launch


class ProductViewModel (application: Application ) : // view modele context veriyoruz ki
// veritabanuna erişssin
        AndroidViewModel(application)  {// normal view model yerine context alabilen

private val dao = ProductDatabase.getDatabase(application).productDao()

private val repository = ProductRepository(dao)

val productList = MutableLiveData<List<Product>> ()



fun loadProducts(){
viewModelScope.launch {
    productList.value = repository.getAllProducts() }
}

fun insertProduct(product : Product ) {
    viewModelScope.launch {
        repository.insertProduct(product)
        loadProducts()
    }
}
    fun deleteProduct(product : Product ) {
        viewModelScope.launch {
           repository.deleteProduct(product)
            loadProducts()
        }
    }

    fun insertSampleProductsIfEmpty() {
        viewModelScope.launch {
            val products = repository.getAllProducts()
            if (products.isEmpty()) {
                repository.insertProduct(
                    Product(name = "Telefon", price = 15000.0, imageResId = R.drawable.phone)
                )
                repository.insertProduct(
                    Product(name = "Tablet", price = 12000.0, imageResId = R.drawable.tablet)
                )
                repository.insertProduct(
                    Product(name = "Kulaklık", price = 2500.0, imageResId = R.drawable.kulaklik)
                )
            }
            loadProducts()
        }
    }


    }

