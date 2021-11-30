package com.app.recipecataloge.ui

import RecipeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.recipecataloge.data.DataRecipe
import com.app.recipecataloge.databinding.FragmentBreakFastBinding


class BreakFastFragment : Fragment() {

    private var _binding: FragmentBreakFastBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakFastBinding.inflate(inflater, container, false)

        binding.rvBreakfast.apply{
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipeAdapter(DataRecipe.listBreakFast)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}