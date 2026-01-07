package com.busra.productapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busra.productapp.databinding.ItemProductBinding
import com.busra.productapp.model.Product

class ProductAdapter (private var productList: List<Product>,
private val onItemClick:(Product) -> Unit

) // constructor

    :  // miras alıyor

    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


  inner class ProductViewHolder(val binding: ItemProductBinding) :
  RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val binding = ItemProductBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val product =productList[position]
        holder.binding.productname.text= product.name
        holder.binding.productprice.text="${product.price}"

        holder.itemView.setOnClickListener{
            onItemClick(product)
        }

    }

    override fun getItemCount(): Int
    = productList.size

fun updateList(newList:List<Product>) {
    productList= newList
    notifyDataSetChanged() // liste değişti ekranı değiştir
}


}