package com.busra.productapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.busra.productapp.R
import com.busra.productapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        // Buton id'si btnGoDetail
        binding.btnGoDetail.setOnClickListener {
            findNavController()
                .navigate(R.id.action_homeFragment_to_productListFragment)
        }
    }
}
