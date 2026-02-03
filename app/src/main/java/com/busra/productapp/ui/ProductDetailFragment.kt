package com.busra.productapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.busra.productapp.R
import com.busra.productapp.databinding.FragmentProductDetailBinding
import com.busra.productapp.model.Product
import com.busra.productapp.viewmodel.ProductViewModel

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail){

    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var viewModel: ProductViewModel
    private lateinit var product: Product


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductDetailBinding.bind(view)

        viewModel =
            ViewModelProvider(requireActivity())
                .get(ProductViewModel::class.java)


        val product =
            ProductDetailFragmentArgs
                .fromBundle(requireArguments())
                .selectedProduct

        binding.ivProductImage.setImageResource(product.imageResId)

        binding.tvProductName.text = product.name
        binding.tvProductPrice.text = "${product.price} ₺"
        binding.tvProductDescription.text =
            "Bu ürün günlük kullanım için tasarlanmıştır.\n\n" +
                    "• Yüksek kaliteli malzeme\n" +
                    "• Uzun ömürlü pil\n" +
                    "• Modern ve şık tasarım\n" +
                    "• Hızlı performans"


        requireActivity().title = product.name
        binding.btnDelete.setOnClickListener {
            viewModel.deleteProduct(product)
            findNavController().popBackStack() }

    }

}