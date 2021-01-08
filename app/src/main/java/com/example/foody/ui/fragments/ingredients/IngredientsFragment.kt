package com.example.foody.ui.fragments.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foody.data.models.ExtendedIngredient
import com.example.foody.data.models.Result
import com.example.foody.databinding.FragmentIngredientsBinding
import com.example.foody.ui.adapters.IngredientsAdapter

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!

    private val mAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")
        val extendedIngredients = myBundle?.extendedIngredients

        setupRecylerView()
        populateRecyler(extendedIngredients!!)

        return binding.root
    }

    private fun setupRecylerView() {
        binding.ingredientsRecyclerview.adapter = mAdapter
        binding.ingredientsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun populateRecyler(data: List<ExtendedIngredient>) {
        data?.let { mAdapter.setData(it) }
    }
}