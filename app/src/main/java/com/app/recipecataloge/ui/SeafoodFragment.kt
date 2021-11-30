package com.app.recipecataloge.ui

import RecipeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.recipecataloge.R
import com.app.recipecataloge.data.Recipes
import com.app.recipecataloge.databinding.FragmentSeafoodBinding


class SeafoodFragment : Fragment() {

    private var _binding: FragmentSeafoodBinding? = null
    private val binding get() = _binding!!

    private var listRecipes: ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        initData()

        binding.rvSeafood.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipeAdapter(listRecipes)
        }

        return binding.root
    }

    private fun initData(){
        activity?.resources?.apply {
            val arrName = getStringArray(R.array.name_seafood)
            val arrCategory = getStringArray(R.array.category_seafood)
            val arrDescription = getStringArray(R.array.description_seafood)
            val arrIngredients = getStringArray(R.array.ingredients_seafood)
            val arrInstruction = getStringArray(R.array.instructions_seafood)
            val arrPhoto = getStringArray(R.array.photo_seafood)
            val arrPrice = getStringArray(R.array.price_seafood)
            val arrCalories = getStringArray(R.array.calories_seafood)
            val arrCarbo = getStringArray(R.array.carbo_seafood)
            val arrProtein = getStringArray(R.array.protein_seafood)

            for (data in arrName.indices){
                val recipes = Recipes(
                    name = arrName[data],
                    category = arrCategory[data],
                    description = arrDescription[data],
                    ingredients = arrIngredients[data],
                    instruction = arrInstruction[data],
                    photo = arrPhoto[data],
                    price = arrPrice[data],
                    calories = arrCalories[data],
                    carbo = arrCarbo[data],
                    protein = arrProtein[data]
                )
                listRecipes.add(recipes)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}