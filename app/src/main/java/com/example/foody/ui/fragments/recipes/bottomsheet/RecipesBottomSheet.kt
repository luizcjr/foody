package com.example.foody.ui.fragments.recipes.bottomsheet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.foody.R
import com.example.foody.data.constants.Constants.Companion.DEFAULT_DIET_TYPE
import com.example.foody.data.constants.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.foody.databinding.FragmentRecipesBinding
import com.example.foody.databinding.FragmentRecipesBottomSheetBinding
import com.example.foody.ui.fragments.recipes.RecipesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.lang.Exception
import java.util.*

class RecipesBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentRecipesBottomSheetBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipesViewModel: RecipesViewModel

    private var selectedMealType = DEFAULT_MEAL_TYPE
    private var selectedMealTypeId = 0
    private var selectedDietType = DEFAULT_DIET_TYPE
    private var selectedDietTypeId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesBottomSheetBinding.inflate(inflater, container, false)

        recipesViewModel.readMealAndDietType.asLiveData().observe(viewLifecycleOwner, { value ->
            selectedMealType = value.selectedMealType
            selectedDietType = value.selectedDietType
            updateChipSelected(value.selectedMealTypeId, binding.cgMealType)
            updateChipSelected(value.selectedDietTypeId, binding.cgDietType)
        })

        binding.cgMealType.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            val mealType = chip.text.toString().toLowerCase(Locale.ROOT)
            selectedMealType = mealType
            selectedMealTypeId = checkedId
        }

        binding.cgDietType.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            val dietType = chip.text.toString().toLowerCase(Locale.ROOT)
            selectedDietType = dietType
            selectedDietTypeId = checkedId
        }

        binding.btnApply.setOnClickListener {
            recipesViewModel.saveMealAndDietType(
                selectedMealType,
                selectedMealTypeId,
                selectedDietType,
                selectedDietTypeId
            )

            val action =
                RecipesBottomSheetDirections.actionRecipesBottomSheetToNavigationRecipes(true)
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun updateChipSelected(chipId: Int, view: ChipGroup) {
        if (chipId != 0) {
            try {
                view.findViewById<Chip>(chipId).isChecked = true
            } catch (e: Exception) {
                Log.d(RecipesBottomSheet::class.java.simpleName, e.message.toString())
            }
        }
    }
}