package com.busra.productapp.ui

import androidx.lifecycle.ViewModelProvider
import com.busra.productapp.viewmodel.ProductViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.busra.productapp.R
import com.busra.productapp.adapter.ProductAdapter
import com.busra.productapp.databinding.FragmentProductListBinding
import com.busra.productapp.model.Product

class ProductListFragment  : Fragment  (R.layout.fragment_product_list) {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProductAdapter

    private lateinit var viewModel: ProductViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProductListBinding.bind(view)

        adapter = ProductAdapter(emptyList()) { selectedProduct ->
            val action =
                ProductListFragmentDirections
                    .actionProductListFragmentToProductDetailFragment(selectedProduct)

            findNavController().navigate(action)
        }

        binding.rvproductlist.layoutManager= LinearLayoutManager(requireContext())
// recyclerview layoutmanager olmadan çalışmaz
        //elemanları dıkey sırala
binding.rvproductlist.adapter = adapter


        viewModel  =
           ViewModelProvider(requireActivity()).get(ProductViewModel::class.java)


    viewModel.productList.observe(viewLifecycleOwner) {
        products->
        adapter.updateList(products)
    }
viewModel.insertSampleProductsIfEmpty()

binding.fabAddProduct.setOnClickListener {
            findNavController().navigate(
                R.id.action_productListFragment_to_addProductFragment
            )

        }



    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




/*   val productList = listOf(
        Product(
            name = "Phone",
            price = 15.5,
            imageResId = R.drawable.phone
        )
,
        Product(
            name = "tablet",
            price = 15.5,
            imageResId = R.drawable.tablet
        )
        ,

        Product(
            name = "Kulaklık",
            price = 15.5,
            imageResId = R.drawable.kulaklik
        )

    )*/


//   binding.rvproductlist.layoutManager = LinearLayoutManager(requireContext())

//  binding.productlisttextid.text="product list "


/* viewModel =
     ViewModelProvider(requireActivity())
         .get(ProductViewModel::class.java)

 viewModel.productList.observe(viewLifecycleOwner) { products ->
     adapter.updateList(products)
 }
 viewModel.loadProducts() */