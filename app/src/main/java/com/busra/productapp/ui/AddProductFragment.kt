package com.busra.productapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.busra.productapp.R
import com.busra.productapp.databinding.FragmentAddProductBinding
import com.busra.productapp.model.Product
import com.busra.productapp.viewmodel.ProductViewModel


class AddProductFragment : Fragment(R.layout.fragment_add_product) {


    private lateinit var binding: FragmentAddProductBinding
    private lateinit var viewModel: ProductViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding= FragmentAddProductBinding.bind(view)

        viewModel =
            ViewModelProvider(requireActivity())
                .get(ProductViewModel::class.java)


        binding.btnSave.setOnClickListener {

            val name = binding.etProductName.text.toString()
            val price = binding.etProductPrice.text.toString().toDouble()


            val product = Product(
                name = name,
                price = price,
                imageResId = R.drawable.ic_launcher_foreground
            )
            viewModel.insertProduct(product)
            findNavController().popBackStack()







        }


        }


}