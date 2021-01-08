package com.example.foody.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foody.R
import com.example.foody.data.models.Result
import com.example.foody.databinding.FragmentInstructionsBinding
import com.example.foody.databinding.FragmentOverviewBinding

class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInstructionsBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        binding.instructionsWebView.webViewClient = object : WebViewClient() {}
        val websiteUrl = myBundle!!.sourceUrl
        binding.instructionsWebView.loadUrl(websiteUrl!!)

        return binding.root
    }
}